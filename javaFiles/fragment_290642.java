inputButton.setOnAction(e -> {
    inputFile = new File(fileInput.getText());
    if (inputFile.exists()) {
        window.close();
    }
});