private Parent getContent() {
    ModelManager manager = new ModelManager();
    ObservableList<String> uploading = FXCollections.observableArrayList("one", "two", "three");

    ObservableList<String> items = FXCollections.observableArrayList();
    manager.getMessages().addListener((ListChangeListener) c -> {

        while (c.next()) {
            if (c.wasAdded()) {
                Platform.runLater(() ->  
                    items.addAll(c.getFrom(), c.getAddedSubList()));
            } 
            if (c.wasRemoved()) {
                Platform.runLater(() ->
                     items.removeAll(c.getRemoved()));
            }
        }
    });


    ListView<String> list = new ListView<>(items);
    Button button = new Button("start");
    button.setOnAction(ev -> {
        uploading.stream().forEach(e -> manager.addFile(e));
        manager.startBackup();
    });
    BorderPane pane = new BorderPane(list);
    pane.setBottom(button);
    return pane;
}

@Override
public void start(Stage stage) throws Exception {
    Scene scene = new Scene(getContent());
    stage.setScene(scene);
    stage.show();
}