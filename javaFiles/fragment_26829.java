import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.stage.Stage;

public class TreeTableViewTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        TreeTableView<Item> table = new TreeTableView<>();
        TreeTableColumn<Item, String> col = new TreeTableColumn<>("Item");
        col.setCellValueFactory(cellData -> cellData.getValue().getValue().nameProperty());
        col.setPrefWidth(250);
        table.getColumns().add(col);
        TreeTableColumn<Item, Number> valueCol = new TreeTableColumn<>("Value");
        valueCol.setCellValueFactory(cellData -> cellData.getValue().getValue().valueProperty());
        valueCol.setPrefWidth(150);
        table.getColumns().add(valueCol);

        table.setRoot(createRandomTree(50));

        Scene scene = new Scene(table);
        scene.getStylesheets().add("style.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private TreeItem<Item> createRandomTree(int nItems) {
        Random rng = new Random();
        TreeItem<Item> root = new TreeItem<>(new Item("Item 1", rng.nextInt(1000)));
        root.setExpanded(true);
        List<TreeItem<Item>> items = new ArrayList<>();
        items.add(root);
        for (int i = 2 ; i <= nItems ; i++) {
            TreeItem<Item> item = new TreeItem<>(new Item("Item "+i, rng.nextInt(1000)));
            item.setExpanded(true);
            items.get(rng.nextInt(items.size())).getChildren().add(item);
            items.add(item);
        }
        return root ;
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


        public final String getName() {
            return this.nameProperty().get();
        }


        public final void setName(final String name) {
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