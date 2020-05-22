public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            VBox root = new VBox();
            Scene scene = new Scene(root,400,400);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

            SampleModel model = new SampleModel();
            model.toDoList.addAll(new ToDo("Brooming", ToDo.Importance.DONTCARE),
                    new ToDo("Taking a nap", ToDo.Importance.FIRSTPRIO),
                    new ToDo("Cooking", ToDo.Importance.MUST),
                    new ToDo("Wash the car", ToDo.Importance.DONTCARE),
                    new ToDo("Pay the bills", ToDo.Importance.SHALL));

            TableView<ToDo> tableView = new TableView<ToDo>();

            TableColumn<ToDo, String> colTask = new TableColumn<ToDo, String>();
            colTask.setCellValueFactory(new PropertyValueFactory<>("task"));

            TableColumn<ToDo, String> colImportance = new TableColumn<ToDo, String>();
            colImportance.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().importanceProperty().get().toString()));

            tableView.getColumns().addAll(colTask, colImportance);

            tableView.setItems(model.toDoList);

            HBox hbox = new HBox();
            TextArea textArea = new TextArea();
            textArea.setPrefSize(180, 15);
            ComboBox<ToDo.Importance> cb = new ComboBox<ToDo.Importance>();
            cb.setItems(FXCollections.observableArrayList(ToDo.Importance.FIRSTPRIO, ToDo.Importance.DONTCARE, ToDo.Importance.MUST));

            Button btnAdd = new Button("Add");
            btnAdd.setOnAction(e -> model.updateBuffer(new ToDo(textArea.getText(), cb.getValue())));

            hbox.getChildren().addAll(textArea, cb, btnAdd);
            root.getChildren().addAll(hbox, tableView);

            Thread thread = new Thread(model);
            thread.setDaemon(true);
            thread.start();


            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}