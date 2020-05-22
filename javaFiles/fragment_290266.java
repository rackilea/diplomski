public void start(Stage primaryStage) throws Exception {
    try {
        AnchorPane root = FXMLLoader.load(getClass().getResource("fxml/Main.fxml"));
        Scene scene = new Scene(root, 600, 400);
        //how would i add something here or further on?
        root.getChildren().add(new Polygon(10,20,30,10,20,30));
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Test");
        primaryStage.show();
    } catch (Exception e) {
        e.printStackTrace();
      // don't leave me hanging bro!
        Platform.exit();
    }
}