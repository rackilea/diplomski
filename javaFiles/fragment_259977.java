@FXML
private void onBack() throws IOException{
    stage = (Stage)childTVPane.getScene().getWindow();// pane you are ON
    paneStart = FXMLLoader.load(getClass().getResource("start.fxml"));// pane you are GOING TO
    Scene scene = new Scene(paneStart);// pane you are GOING TO
    scene.getStylesheets().add(getClass().getResource("diary.css").toExternalForm());
    stage.setScene(scene);
    stage.setTitle("Diary"); 
    stage.show();
    stage.sizeToScene();
    stage.centerOnScreen(); 
}