public static boolean inHierarchy(Node node, Node potentialHierarchyElement) {
    if (potentialHierarchyElement == null) {
        return true;
    }
    while (node != null) {
        if (node == potentialHierarchyElement) {
            return true;
        }
        node = node.getParent();
    }
    return false;
}

@Override
public void start(Stage primaryStage) {
    TextField textField = new TextField();
    textField.setMinSize(400, Region.USE_PREF_SIZE);
    textField.setMaxWidth(400);
    textField.setEditable(false);
    textField.textProperty().bind(Bindings.when(textField.focusedProperty()).then("Got the Focus!").otherwise("Please give me the focus!"));

    StackPane root = new StackPane();
    root.getChildren().add(textField);

    Scene scene = new Scene(root, 500, 200);

    scene.addEventFilter(MouseEvent.MOUSE_CLICKED, evt -> {
        if (!inHierarchy(evt.getPickResult().getIntersectedNode(), textField)) {
            root.requestFocus();
        }
    });

    primaryStage.setScene(scene);
    primaryStage.show();
}