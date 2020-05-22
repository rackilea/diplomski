@FXML
public void addValue(MouseEvent e) throws IOException {

    Stage stage = new Stage ();
    FXMLLoader loader = new FXMLLoader(getClass().getResource(2ndFXML.fxml));
    Parent root = loader.load();
    // I guess you forgot this line????
    stage.setScene(new Scene(root));
    stage.initModality(Modality.APPLICATION_MODAL);
    stage.iniOwner(clickedButton.getScene().getWindow();
    stage.showAndWait();

    SecondController secondController = loader.getController();
    Set<String> selectedData = secondController.getSelectedData();
    // do whatever you need to do with the data...

}