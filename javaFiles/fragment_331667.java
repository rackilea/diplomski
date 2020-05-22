EventBus eventBus = new EventBus();
ClientHandler clientHandler = new ClientHandler(eventBus);
// ...
FXMLLoader loader = new FXMLLoader(getClass().getResource("/path/to/fxml/file"));
Parent root = loader.load();
MainController controller = loader.getController();
eventBus.register(controller);
Scene scene = new Scene(root);
// put scene in stage and show stage, etc...