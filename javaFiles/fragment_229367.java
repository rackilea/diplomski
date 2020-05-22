FXMLLoader loader = new FXMLLoader(url);
loader.setControllerFactory(c -> {
    MyController controller = new MyController();
    controller.setId(userId);
    return controller;
});
...
Node n = loader.load();