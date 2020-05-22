import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Pair;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        var table = System.getProperties().stringPropertyNames().stream()
                .map(name -> new Pair<>(name, System.getProperty(name)))
                .collect(collectingAndThen(toCollection(FXCollections::observableArrayList), TableView::new));
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.getSelectionModel().setCellSelectionEnabled(true); // Not sure if you're using cell or row selection

        var keyCol = new TableColumn<Pair<String, String>, String>("Key");
        keyCol.setCellValueFactory(new PropertyValueFactory<>("key"));
        table.getColumns().add(keyCol);

        var valCol = new TableColumn<Pair<String, String>, String>("Value");
        valCol.setCellValueFactory(new PropertyValueFactory<>("value"));
        valCol.setCellFactory(tc -> new TableCell<>() {
            { getStyleClass().add("highlighted-table-cell"); }
            @Override protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item);
                }
            }
        });
        table.getColumns().add(valCol);

        var scene = new Scene(table, 600, 400);
        scene.getStylesheets().add("Main.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}