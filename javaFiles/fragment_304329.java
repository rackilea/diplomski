@Override
public void start(Stage stage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("/fxml/sample.fxml"));
    Scene scene = new Scene(root, 800, 800);
    stage.setScene(scene);
    stage.show();
}