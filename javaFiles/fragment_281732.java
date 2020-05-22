import java.util.Arrays;
import java.util.List;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TableViewByColumns extends Application {

    @Override
    public void start(Stage primaryStage) {
        List<Integer> intValues = Arrays.asList(1, 2, 3, 4, 5);
        List<String> stringValues = Arrays.asList("One", "Two", "Three", "Four", "Five");

        TableView<Integer> table = new TableView<>();
        for (int i = 0; i < intValues.size() && i < stringValues.size(); i++) {
            table.getItems().add(i);
        }

        TableColumn<Integer, Number> intColumn = new TableColumn<>("Value");
        intColumn.setCellValueFactory(cellData -> {
            Integer rowIndex = cellData.getValue();
            return new ReadOnlyIntegerWrapper(intValues.get(rowIndex));
        });

        TableColumn<Integer, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(cellData -> {
            Integer rowIndex = cellData.getValue();
            return new ReadOnlyStringWrapper(stringValues.get(rowIndex));
        });

        table.getColumns().add(intColumn);
        table.getColumns().add(nameColumn);

        primaryStage.setScene(new Scene(new BorderPane(table), 600, 600));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}