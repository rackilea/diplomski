TextField fileInput = new TextField();
Button inputButton = new Button("Upload File");
inputButton.setDisable(true);
fileInput.textProperty().addListener((obs, oldText, newText) -> 
    inputButton.setDisable( ! new File(newText).exists() ) );
inputButton.setOnAction(e -> {
    inputFile = new File(fileInput.getText());
    window.close();
});