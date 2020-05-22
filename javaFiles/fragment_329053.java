import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableRow;
import javafx.scene.control.TreeTableView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class StyledTreeTableView extends Application {

    private static final int MAX_VALUE = 1000 ;

    @Override
    public void start(Stage primaryStage) {
        TreeTableView<Item> treeTable = new TreeTableView<>();
        treeTable.setRoot(createTreeItem(1));

        treeTable.setRowFactory(ttv -> new TreeTableRow<Item>() {
            @Override
            public void updateItem(Item item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setText(null);
                    getStyleClass().remove("highlight");
                } else {
                    setText(item.toString());
                    if (item.getValue() % 10 == 3 || item.getValue() % 10 == 4) {
                        if (! getStyleClass().contains("highlight")) {
                            getStyleClass().add("highlight");
                        }
                    } else {
                        getStyleClass().remove("highlight");
                    }
                }
            }
        });

        TreeTableColumn<Item, String> nameCol = new TreeTableColumn<>("Item");
        nameCol.setCellValueFactory(cellData -> cellData.getValue().getValue().nameProperty());
        treeTable.getColumns().add(nameCol);

        for (int colIndex = 1 ; colIndex < 10 ; colIndex++) {
            TreeTableColumn<Item, Number> valueCol = new TreeTableColumn<>("Value * "+colIndex);
            final int multiplier = colIndex ;
            valueCol.setCellValueFactory(cellData -> cellData.getValue().getValue().valueProperty().multiply(multiplier));
            treeTable.getColumns().add(valueCol);
        }

        BorderPane root = new BorderPane(treeTable);
        Scene scene = new Scene(root, 600, 600);
        scene.getStylesheets().add("styled-tree-table.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private TreeItem<Item> createTreeItem(int value) {
        Item item = new Item("Item "+ value, value);
        TreeItem<Item> treeItem = new TreeItem<>(item);
        if (value < MAX_VALUE) {
            for (int i = 0 ; i < 10; i++) {
                treeItem.getChildren().add(createTreeItem(value * 10 + i));
            }
        }
        return treeItem ;
    }

    public static class Item {
        private final StringProperty name = new SimpleStringProperty();
        private final IntegerProperty value = new SimpleIntegerProperty();

        public Item(String name, int value) {
            setName(name);
            setValue(value);
        }

        public final StringProperty nameProperty() {
            return this.name;
        }

        public final java.lang.String getName() {
            return this.nameProperty().get();
        }

        public final void setName(final java.lang.String name) {
            this.nameProperty().set(name);
        }

        public final IntegerProperty valueProperty() {
            return this.value;
        }

        public final int getValue() {
            return this.valueProperty().get();
        }

        public final void setValue(final int value) {
            this.valueProperty().set(value);
        }


    }

    public static void main(String[] args) {
        launch(args);
    }
}