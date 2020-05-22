@Override
public void start(Stage stage) throws Exception {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("Window3DSceneView.fxml"));
    Parent root = loader.load();
    Window3DController controller = loader.getController();

    Scene scene = new Scene(root, 1200, 800, true, SceneAntialiasing.BALANCED);
    scene.setOnKeyPressed(e -> controller.onKeyPressed(e));
    ...
}