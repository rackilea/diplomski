public void start(Stage primaryStage) {

    StackPane root = new StackPane();

    /* example Treeview */
    TreeView<String> tw = new TreeView<>();
    CheckBoxTreeItem<String> rootNode = new CheckBoxTreeItem<>("Root");
    CheckBoxTreeItem<String> blockOne = new CheckBoxTreeItem<>("Block1");
    CheckBoxTreeItem<String> childA = new CheckBoxTreeItem<>("ChildA");
    CheckBoxTreeItem<String> childB = new CheckBoxTreeItem<>("ChildB");
    blockOne.getChildren().add(childA);
    blockOne.getChildren().add(childB);
    CheckBoxTreeItem<String> blockTwo = new CheckBoxTreeItem<>("Block2");
    CheckBoxTreeItem<String> childC = new CheckBoxTreeItem<>("ChildC");
    CheckBoxTreeItem<String> childD = new CheckBoxTreeItem<>("ChildD");
    blockTwo.getChildren().add(childC);
    blockTwo.getChildren().add(childD);
    rootNode.getChildren().add(blockOne);
    rootNode.getChildren().add(blockTwo);
    tw.setRoot(rootNode);

    /* add CheckBoxes */
    tw.setCellFactory(CheckBoxTreeCell.<String>forTreeView());

    root.getChildren().add(tw);
    Scene scene = new Scene(root, 300, 250);
    primaryStage.setTitle("Hello World!");
    primaryStage.setScene(scene);
    primaryStage.show();
}