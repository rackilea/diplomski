public void login(ActionEvent event) {
    try {
        if (loginModel.isLoggedIn(txtLogin.getText(), txtPassField.getText())) {
            lblDBStatus.setText("Username and password are correct");

            String fxmlFile = "/fxml/User.fxml";
            LOG.debug("Loading FXML for User view from: {}", fxmlFile);

            LOG.info("Hiding login page");
            ((Node) event.getSource()).getScene().getWindow().hide();


            userStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane rootNode = loader.load(getClass().getResource(fxmlFile).openStream());
            UserController userController = (UserController) loader.getController();
            userController.getUserName(txtLogin.getText());

            LOG.info("Showing User page");
            Scene scene = new Scene(rootNode);
            scene.getStylesheets().add("/styles/user-controller.css");

            userStage.setTitle("WindOptimizer");
            userStage.setScene(scene);
            userStage.show();


        } else {
            lblDBStatus.setText("Username and password are incorrect");

        }
    } catch (SQLException | IOException e) {
        e.printStackTrace();
    }
}