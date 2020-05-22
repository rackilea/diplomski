public void start(Stage stage) throws IOException {
    stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
        @Override
        public void handle(WindowEvent t) {
            Platform.exit();
            System.exit(0);
        }
    });

    FXMLLoader loader = new FXMLLoader(getClass().getResource("NavigationView.fxml"));
    Parent root = loader.load();

    MyController controller = loader.getController();
    SomeOtherClass someOtherObject = new SomeOtherClass();
    someOtherObject.setController(controller);

    Scene scene = new Scene(root);
    stage.setResizable(false);
    stage.setScene(scene);
    stage.show();
    stage.setTitle("Greenhouse");
}