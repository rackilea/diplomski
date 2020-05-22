/**
 * baseGUI function
 * Creates a baseGUI function
 * @param root
 * @param nodes
 */
private void baseGUI(Pane root, Node... nodes)
{
    if (root instanceof VBox)
    {
        ((VBox) root).setAlignment(Pos.CENTER);
        ((VBox) root).setSpacing(10);
        ((VBox)root).getChildren().add(nodes);
    }
    root.setPadding(new Insets(10));
    Scene scene = new Scene(root, 250, 250);
    primaryStage.setScene(scene);
    primaryStage.show();
}