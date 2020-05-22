URL location = getClass().getResource("MainScreen.fxml");
FXMLLoader fxmlLoader = new FXMLLoader(location);
// ... more fxmlLoader configuration ...
fxmlLoader.load();

// assuming your own Controller class has a setLocation method
Controller c = (Controller) fxmlLoader.getController();
c.setLocation(location);