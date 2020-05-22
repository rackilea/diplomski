import java.util.Random;
import java.util.function.Function;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.css.PseudoClass;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class TableViewStyleLastRow extends Application {

    @Override
    public void start(Stage primaryStage) {
        TableView<Item> table = new TableView<>();
        table.getColumns().add(column("Item", Item::nameProperty));
        table.getColumns().add(column("Value", Item::valueProperty));

        PseudoClass lastRow = PseudoClass.getPseudoClass("last-row");
        table.setRowFactory(tv -> new TableRow<Item>(){
            @Override
            public void updateIndex(int index) {
                super.updateIndex(index);
                pseudoClassStateChanged(lastRow, index >=0 && index == table.getItems().size() - 1);
            }
        });

        Random rng = new Random();
        for (int i = 1 ; i <= 25 ; i++) {
            table.getItems().add(new Item("Item "+i, rng.nextInt(200)));
        }

        Scene scene = new Scene(table);
        scene.getStylesheets().add("style-last-row.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private static <S,T> TableColumn<S,T> column(String title, Function<S, Property<T>> prop) {
        TableColumn<S, T> col = new TableColumn<>(title);
        col.setCellValueFactory(cellData -> prop.apply(cellData.getValue()));
        return col ;
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