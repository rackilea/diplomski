browseEncrypt.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {


        File selectedFile = chooseEncrypt.showOpenDialog(primaryStage);
        if (selectedFile != null) {
            encryptPath.setText(selectedFile.getPath());
            encryptedFile = selectedFile;//Add This!
            primaryStage.show();//Not sure why this is here?
        }
    }
});