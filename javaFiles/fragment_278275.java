public class Main extends Application {
    private TableView table = new TableView();
    @Override
    public void start(Stage primaryStage) throws Exception{
        ObservableList<Data> data = FXCollections.observableArrayList(
                new Data("Jacob", "Smith", true),
                new Data("Isabella", "Johnson",true),
                new Data("Ethan", "Williams", false),
                new Data("Emma", "Jones", true),
                new Data("Michael", "Brown", true)
        );
        TableColumn firstDataCol = new TableColumn("Data1");
        firstDataCol.setMinWidth(100);
        firstDataCol.setCellValueFactory(
                new PropertyValueFactory<Data, String>("data1"));

        TableColumn secondDataCol = new TableColumn("Data2");
        secondDataCol.setMinWidth(100);
        secondDataCol.setCellValueFactory(
                new PropertyValueFactory<Data, String>("data2"));

        /*TableColumn isGreenCol = new TableColumn("IsGreen");
        isGreenCol.setMinWidth(200);
        isGreenCol.setCellValueFactory(
                new PropertyValueFactory<Data, Boolean>("isGreen"));*/

        table.setRowFactory(new Callback<TableView<Data>, TableRow<Data>>() {
            @Override
            public TableRow<Data> call(TableView<Data> tableView) {
                final TableRow<Data> row = new TableRow<Data>() {
                    @Override
                    protected void updateItem(Data data, boolean empty){
                        super.updateItem(data, empty);
                        if (data!=null&&data.isGreen.get()) {
                           setStyle("-fx-text-background-color: green;");

                        } else {
                            setStyle("-fx-text-background-color: red;");
                        }
                    }
                };

                return row;
            }
        });

        table.setItems(data);
        table.getColumns().addAll(firstDataCol, secondDataCol);
        Parent window = new VBox();
        ((VBox) window).getChildren().add(new Label("example of small window:"));
        primaryStage.setTitle("example");
        ((VBox) window).getChildren().add(table);
        Scene scene=new Scene(window);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public class Data {
        private final SimpleStringProperty data1;
        private final SimpleStringProperty data2;
        private final SimpleBooleanProperty isGreen;

        public Data(String data1, String data2, Boolean isGreen) {
            this.data1 = new SimpleStringProperty(data1);
            this.data2 = new SimpleStringProperty(data2);
            this.isGreen = new SimpleBooleanProperty(isGreen);
        }

        public String getData1() {
            return data1.get();
        }

        public SimpleStringProperty data1Property() {
            return data1;
        }

        public String getData2() {
            return data2.get();
        }

        public SimpleStringProperty data2Property() {
            return data2;
        }

        public boolean isIsGreen() {
            return isGreen.get();
        }

        public SimpleBooleanProperty isGreenProperty() {
            return isGreen;
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}