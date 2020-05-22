TextField fileInput = new TextField();
Button inputButton = new Button("Upload File");
inputButton.disableProperty().bind(Bindings.createBooleanBinding(
    () -> ! new File(fileInput.getText()).exists(), 
    fileInput.textProperty()));
inputButton.setOnAction(e -> {
    inputFile = new File(fileInput.getText());
    window.close();
});