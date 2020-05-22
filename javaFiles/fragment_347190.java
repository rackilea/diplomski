import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class CellValueFactoryExample extends Application {
    private ObservableList<Part> items;

    @Override
    public void init() {
        items = FXCollections.observableArrayList();
        for (int i = 0; i < 10; i++) {
            Part part = new Part(i, String.valueOf(i), (double) i, i, i, i);
            items.add(part);
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Inventory");
        TableView<Part> table = createTable();
        BorderPane root = new BorderPane();
        root.setCenter(table);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private TableView<Part> createTable() {
        TableView<Part> table = new TableView<Part>(items);

        TableColumn<Part, Number> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(this::getIdColumnValue);

        TableColumn<Part, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(this::getNameColumnValue);

        TableColumn<Part, Number> priceCol = new TableColumn<>("Price");
        priceCol.setCellValueFactory(this::getPriceColumnValue);

        TableColumn<Part, Number> stockCol = new TableColumn<>("Stock");
        stockCol.setCellValueFactory(this::getStockColumnValue);

        TableColumn<Part, Number> minCol = new TableColumn<>("Min");
        minCol.setCellValueFactory(this::getMinColumnValue);

        TableColumn<Part, Number> maxCol = new TableColumn<>("Max");
        maxCol.setCellValueFactory(this::getMaxColumnValue);

        table.getColumns().addAll(idCol, nameCol, priceCol, stockCol, minCol, maxCol);
        return table;
    }

    private ObservableValue<Number> getIdColumnValue(CellDataFeatures<Part, Number> param) {
        return new SimpleIntegerProperty(param.getValue().getId());
    }

    private ObservableValue<String> getNameColumnValue(CellDataFeatures<Part, String> param) {
        return new SimpleStringProperty(param.getValue().getName());
    }

    private ObservableValue<Number> getPriceColumnValue(CellDataFeatures<Part, Number> param) {
        return new SimpleDoubleProperty(param.getValue().getPrice());
    }

    private ObservableValue<Number> getStockColumnValue(CellDataFeatures<Part, Number> param) {
        return new SimpleIntegerProperty(param.getValue().getStock());
    }

    private ObservableValue<Number> getMinColumnValue(CellDataFeatures<Part, Number> param) {
        return new SimpleIntegerProperty(param.getValue().getMin());
    }

    private ObservableValue<Number> getMaxColumnValue(CellDataFeatures<Part, Number> param) {
        return new SimpleIntegerProperty(param.getValue().getMax());
    }

    public static void main(String[] args) {
        launch(args);
    }
}