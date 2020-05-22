public void start(Stage primaryStage) throws Exception {
    FXMLLoader baseViewLoader = new FXMLLoader(getClass().getResource("Views/BaseView.fxml"));
    baseViewLoader.setLocation(getClass().getResource("Views/BaseView.fxml"));
    baseViewLoader.setController(new BaseViewController());
    Parent root = baseViewLoader.load();

    primaryStage.setResizable(false);
    primaryStage.sizeToScene();

    primaryStage.setTitle("Tiles 2059275");

    Scene gameScene = new Scene(root);

    primaryStage.setScene(gameScene);

    primaryStage.show();

    new GameController(baseViewLoader);
}