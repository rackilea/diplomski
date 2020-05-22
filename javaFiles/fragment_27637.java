@FXML // This method is called by the FXMLLoader when initialization is complete
void initialize() {
    assert button != null : "fx:id=\"button\" was not injected: check your FXML file 'zumpFXML.fxml'.";
    final Zump t1 = new Zump();
    button.setOnAction((ActionEvent event) -> {
        System.out.println("That was easy, wasn't it?");
        t1.octaveUp();
        // Zump.octaveUp();
    });
}