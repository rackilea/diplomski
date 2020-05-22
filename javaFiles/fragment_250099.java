@FXML protected void click(ActionEvent event) throws Exception{
    FXMLLoader fxmlLoader = new FXMLLoader();
    Pane p = (Pane) fxmlLoader.load(getClass().getResource("../view/Options.fxml").openStream());
    Scene scene= menu.getScene();
    scene.setRoot(p);
}