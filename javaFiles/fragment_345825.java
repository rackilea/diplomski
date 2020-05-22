public void loadWindowAndSendDataTest(String path, String appName, ConnectionData connectionData) {
    try {
        Stage subWindow = new Stage();
        subWindow.initModality(Modality.APPLICATION_MODAL);
        FXMLLoader loader = new FXMLLoader();
        Parent parent = loader.load(getClass().getResource(path).openStream());
        Object controller = loader.getController();
        Method getConnectionDataMethod = 
            controller.getClass().getMethod("getConnectionData", ConnectionData.class);
        getConnectionDataMethod.invoke(controller, connectionData);

        Scene scene = new Scene(parent);

        subWindow.setScene(scene);
        subWindow.setTitle(appName);
        subWindow.show();
    } catch(Exception e) {
        e.printStackTrace();
    }
}