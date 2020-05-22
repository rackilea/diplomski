@Override
public void start(Stage primaryStage) throws IOException {
    TreeView<String> treeView = new TreeView<>();

    // create data
    TreeItem<String> root = new TreeItem<>("root");

    TreeItem<String> child1 = new TreeItem<>("child1");
    TreeItem<String> child2 = new TreeItem<>("child2");
    root.getChildren().addAll(child1, child2);

    child1.getChildren().addAll(
            new TreeItem<>("child1-1"),
            new TreeItem<>("child1-2"));

    child2.getChildren().addAll(
            new TreeItem<>("child2-1"),
            new TreeItem<>("child2-2"));

    treeView.setRoot(root);

    Button button = new Button("Change");
    button.disableProperty().bind(treeView.getSelectionModel().selectedItemProperty().isNull());
    TextField textField = new TextField();

    button.setOnAction(evt -> {
        // set text of selected item to TextField text
        TreeItem<String> item = treeView.getSelectionModel().getSelectedItem();
        String text = textField.getText();
        item.setValue(text);
    });

    Scene scene = new Scene(new VBox(treeView, textField, button));

    primaryStage.setScene(scene);
    primaryStage.show();
}