import java.util.HashSet;
import java.util.Set;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TableSelection extends Application {

    TableView<Item> table1 = new TableView<>();
    TableView<Item> table2 = new TableView<>();

    boolean adapting = false;

    @SuppressWarnings("unchecked")
    @Override
    public void start(Stage primaryStage) throws Exception {
        ObservableList<Item> data1 = FXCollections.observableArrayList();
        ObservableList<Item> data2 = FXCollections.observableArrayList();

        String[] names = new String[] { "Wood", "Paper", "Scissors" };

        for (int i = 1; i < 15; i++) {
            Item j = new Item();
            j.setName(names[(int) (Math.random() * names.length)]);
            j.setNn((int) (Math.random() * 100));

            if (i < 5)
                data1.add(j);
            else
                data2.add(j);
        }

        TableColumn<Item, String> nameCol = new TableColumn<>("Name");
        TableColumn<Item, Integer> nnCol = new TableColumn<>("nn");
        nameCol.setCellValueFactory(new PropertyValueFactory<Item, String>("Name"));
        nnCol.setCellValueFactory(new PropertyValueFactory<Item, Integer>("nn"));

        TableColumn<Item, String> nameCol2 = new TableColumn<>("Name");
        TableColumn<Item, Integer> nnCol2 = new TableColumn<>("nn");
        nameCol2.setCellValueFactory(new PropertyValueFactory<Item, String>("Name"));
        nnCol2.setCellValueFactory(new PropertyValueFactory<Item, Integer>("nn"));

        table1.itemsProperty().setValue(data1);
        table1.getColumns().addAll(nameCol, nnCol);

        table2.itemsProperty().setValue(data2);
        table2.getColumns().addAll(nameCol2, nnCol2);

        // table1.setSelectionModel(table2.getSelectionModel());
        table1.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        table2.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        table2.getSelectionModel().selectedItemProperty().addListener((ChangeListener<Item>) (observable, oldValue, newValue) -> {

            if (adapting)
                return;

            try {

                adapting = true;

                selectCurrent(table2);
                selectOthers(table2, table1);

            } finally {
                adapting = false;
            }

        });

        table1.getSelectionModel().selectedItemProperty().addListener((ChangeListener<Item>) (observable, oldValue, newValue) -> {

            if (adapting)
                return;

            try {

                adapting = true;

                selectCurrent(table1);
                selectOthers(table1, table2);

            } finally {
                adapting = false;
            }

        });

        VBox myPane = new VBox();
        myPane.setAlignment(Pos.CENTER);
        myPane.setPadding(new Insets(12));
        myPane.setSpacing(12);
        myPane.setMaxHeight(500);
        myPane.getChildren().addAll(table1, table2);

        Scene myScene = new Scene(myPane);

        primaryStage.setScene(myScene);
        primaryStage.show();
    }

    private void selectCurrent(TableView<Item> currentTableView) {

        Set<String> names = new HashSet<>();

        for (Item item : currentTableView.getSelectionModel().getSelectedItems()) {
            names.add(item.getName());
        }

        for (String name : names) {

            for (Item item : currentTableView.getItems()) {
                if (name.equals(item.getName())) {
                    currentTableView.getSelectionModel().select(item);
                }
            }

        }

    }

    private void selectOthers(TableView<Item> sourceTableView, TableView<Item> targetTableView) {

        Set<String> names = new HashSet<>();

        for (Item item : sourceTableView.getSelectionModel().getSelectedItems()) {
            names.add(item.getName());
        }

        targetTableView.getSelectionModel().clearSelection();

        for (String name : names) {

            for (Item item : targetTableView.getItems()) {
                if (name.equals(item.getName())) {
                    targetTableView.getSelectionModel().select(item);
                }
            }

        }

    }

    public class Item {
        String name;
        int Nn;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getNn() {
            return Nn;
        }

        public void setNn(int nn) {
            Nn = nn;
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}