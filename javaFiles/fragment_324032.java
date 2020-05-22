@Override public void start(Stage stage) {
    Scene scene = new Scene(new Group());
    scene.setRoot(new BuildLayout(stage));

    Screen screen = Screen.getPrimary();
    Rectangle2D bounds = screen.getVisualBounds();

    stage.setTitle("Application Name");
    stage.setScene(scene);
    stage.setX(bounds.getMinX());
    stage.setY(bounds.getMinY());
    stage.setWidth(bounds.getWidth());
    stage.setHeight(bounds.getHeight());          
    stage.show();
}