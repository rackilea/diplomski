if(/*your if condition*/){
    YourController controller = new YourController();
    FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(fxmlPath));
    loader.setController(controller);
    Parent root = loader.load();
    Scene scene = new Scene(root, width, height, Color.WHITE);
    Stage stage = new Stage();
    stage.setX(xPos);
    stage.setY(yPos);
    stage.setScene(scene);
    stage.show();
}