public void start(Stage stage) throws Exception {
    FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/loginScene.fxml"));
    Parent root = loader.load();
    stage.setScene(new Scene(root));
    stage.show();
}