public void loadSecondFxml(){
    //Load new FXML and assign it to scene
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("newFXML.fxml"));
    Parent root = (Parent) fxmlLoader.load();
    Scene scene = new Scene(root, 600, 65);
    jfxPanel.setScene(scene);
}