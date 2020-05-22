public static ControllerClass display(String title, String message) throws IOException {
    Stage stage = new Stage();
    stage.initModality(Modality.APPLICATION_MODAL);
    FXMLLoader loader = new FXMLLoader();
    Parent root= loader.load(getClass().getResource("/Alertbox.fxml"));
    ControllerClass controller = loader.getController();    
    controller.lblResult.setText("message");
    stage.setTitle(title);
    stage.setScene(new Scene(root));
    stage.show();
    return controller;