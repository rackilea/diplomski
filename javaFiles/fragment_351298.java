public void openTurbinesTab(ActionEvent event) {

    try {
        String fxmlFile = "/fxml/WindTurbines.fxml";
        LOG.debug("Loading FXML for Turbines view from: {}", fxmlFile);

        LOG.info("Hiding user page");

        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane rootNode = loader.load(getClass().getResource(fxmlFile).openStream());

        TurbinesController turbinesController = (TurbinesController) loader.getController();
        turbinesController.getStationName(stationCB.getValue().toString());

        LOG.info("Showing Turbines page");
        Scene scene = new Scene(rootNode);
        scene.getStylesheets().add("/styles/turbines-controller.css");

        stage.setTitle("WindOptimizer");
        stage.setScene(scene);
        stage.initOwner(LoginController.userStage);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.showAndWait();

    } catch (IOException e) {
        e.printStackTrace();
    }
}