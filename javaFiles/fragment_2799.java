Controller controller = ....;
  FXMLLoader loader = new FXMLLoader(Resource.onClassPath("MyScene.fxml").getURL());
  loader.setController(controller);
  AnchorPane pane = loader.load();

  controller.setTestLabel("This is a test.");