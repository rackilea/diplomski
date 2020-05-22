import java.math.BigInteger;
import java.util.function.Function;

import javafx.application.Application;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.stage.Stage;

public class UnlimitedTreeTableView extends Application {


    @Override
    public void start(Stage primaryStage) {
        TreeTableView<Item> treeTable = new TreeTableView<>();
        treeTable.setRoot(createTreeItem(BigInteger.ZERO));

        treeTable.getColumns().add(column("Item", Item::getName));
        treeTable.getColumns().add(column("Value", Item::getValue));

        primaryStage.setScene(new Scene(treeTable));
        primaryStage.show();
    }

    private TreeItem<Item> createTreeItem(BigInteger value) {
        TreeItem<Item> item = new TreeItem<Item>(new Item(String.format("Item %,d", value), value)) {

            private boolean childrenComputed = false ;

            {
                expandedProperty().addListener((obs, wasExpanded, isNowExpanded) -> {
                    if (! isNowExpanded) { // remove child nodes...
                        super.getChildren().clear();
                        childrenComputed = false ;
                    }
                });
            }

            @Override
            public ObservableList<TreeItem<Item>> getChildren() {
                if (! childrenComputed) {
                    Item item = getValue();
                    BigInteger value = item.getValue() ;
                    BigInteger valueTimes10 = value.multiply(BigInteger.TEN);
                    for (int i = 0 ; i < 10 ; i++) {
                        BigInteger v = BigInteger.valueOf(i);
                        super.getChildren().add(createTreeItem(valueTimes10.add(v)));
                    }
                    childrenComputed = true ;
                }
                return super.getChildren();
            }

            @Override
            public boolean isLeaf() {
                return false ;
            }
        };

        return item ;
    }

    private static <S,T> TreeTableColumn<S,T> column(String title, Function<S,T> property) {
        TreeTableColumn<S,T> column = new TreeTableColumn<>(title);
        column.setCellValueFactory(cellData -> 
            new SimpleObjectProperty<T>(property.apply(cellData.getValue().getValue())));
        column.setPrefWidth(200);
        return column ;
    }

    public static class Item {
        private final BigInteger value ;
        private final String name ;

        public Item(String name, BigInteger value) {
            this.name = name ;
            this.value = value ;
        }

        public BigInteger getValue() {
            return value;
        }

        public String getName() {
            return name;
        }


    }

    public static void main(String[] args) {
        launch(args);
    }
}