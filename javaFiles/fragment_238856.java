public class WrappedTreeView extends Application {

    @Override
    public void start(Stage stage) {
        final Scene scene = new Scene(new Group(), 200, 400);
        Group sceneRoot = (Group) scene.getRoot();

        scene.getStylesheets().add(getClass().getResource("application.css").toString());

        TreeItem<String> root = new TreeItem<>("Root");
        root.setExpanded(true);

        TreeItem<String> childNode1 = new TreeItem<>("I am a very long node - the first one -, my text must be wrapped! If it is not wrapped, it's a problem!");
        TreeItem<String> childNode2 = new TreeItem<>("I am a very long node - the second one -, my text must be wrapped! If it is not wrapped, it's a problem!");
        TreeItem<String> childNode3 = new TreeItem<>("I am a very long node - the third one -, my text must be wrapped! If it is not wrapped, it's a problem!");

        root.getChildren().addAll(childNode1, childNode2, childNode3);
        childNode2.getChildren().add(new TreeItem<>("And I am a very long embedded node, so my text must be wrapped!"));

        TreeView<String> treeView = new TreeView<>(root);
        treeView.setCellFactory(item -> {
            TreeCell<String> treeCell = new TreeCell<String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item != null && !empty)
                        setText(item);
                    else
                        setText("");
                }
            };

            treeCell.prefWidthProperty().bind(treeView.widthProperty().subtract(5.0));
            return treeCell;
        });

        treeView.setMaxWidth(200);

        sceneRoot.getChildren().add(treeView);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}