public <T extends ConnectionDataProvider> void loadWindowAndSendDataTest(
        String path, String appName, 
        ConnectionData connectionData, Class<T> controllerType) {

    try {
        Stage subWindow = new Stage();
        subWindow.initModality(Modality.APPLICATION_MODAL);
        FXMLLoader loader = new FXMLLoader();
        Parent parent = loader.load(getClass().getResource(path).openStream());
        T controller = loader.getController();

        // if you wanted to cast explicitly here, you could do:
        // T controller = controllerType.cast(loader.getController());

        controller.getConnectionData(connectionData);

        // do something with controllerType if you need....

        Scene scene = new Scene(parent);

        subWindow.setScene(scene);
        subWindow.setTitle(appName);
        subWindow.show();
    } catch(Exception e) {
        e.printStackTrace();
    }
}