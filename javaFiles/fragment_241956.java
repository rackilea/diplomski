@FXML
void actionListenerSuche(ActionEvent event) {
    try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Suche.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();

        SucheController sucheController = fxmlLoader.getController();
        sucheController.setMengeController(this);

        Stage stage = new Stage();
        stage.setScene(new Scene(root1));  
        stage.show();
    } catch(Exception e) {
        e.printStackTrace();
    }
}