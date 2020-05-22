import javafx.application.Application;
    import javafx.collections.FXCollections;
    import javafx.collections.ObservableList;
    import javafx.scene.Scene;
    import javafx.scene.control.TableColumn;
    import javafx.scene.control.TableView;
    import javafx.scene.control.cell.PropertyValueFactory;
    import javafx.stage.Stage;

    public class TableApp extends Application {

        private final ObservableList<TblQuery> data =
                FXCollections.observableArrayList(
                        new TblQuery("Jacob", "Smith", "jacob.smith@example.com"),
                        new TblQuery("Isabella", "Johnson", "isabella.johnson@example.com"),
                        new TblQuery("Ethan", "Williams", "ethan.williams@example.com"),
                        new TblQuery("Emma", "Jones", "emma.jones@example.com"),
                        new TblQuery("Michael", "Brown", "michael.brown@example.com")
                );

        private javafx.scene.control.TableView<TblQuery> tableview = new TableView<>();

        public static void main(String[] args) {
            launch(args);
        }

        @Override
        public void start(Stage primaryStage) throws Exception {
            primaryStage.setTitle("Cycle reloader");
            primaryStage.setResizable(false);
            primaryStage.setScene(new Scene(tableview));

            tableview.setEditable(true);

            TableColumn idCol = new TableColumn("What");
            idCol.setMinWidth(80);
            idCol.setCellValueFactory(
                    new PropertyValueFactory<TblQuery, String>("id"));

            TableColumn workflowCol = new TableColumn("Workflow name");
            workflowCol.setMinWidth(236);
            workflowCol.setCellValueFactory(
                    new PropertyValueFactory<TblQuery, String>("workflow"));

            TableColumn dateCol = new TableColumn("AS OF DAY");
            dateCol.setMinWidth(80);
            dateCol.setCellValueFactory(
                    new PropertyValueFactory<TblQuery, String>("date"));

            tableview.setItems(data);
            tableview.getColumns().addAll(idCol, workflowCol, dateCol);

            primaryStage.show();
        }
    }