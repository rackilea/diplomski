@FXML
private void uploadImage(ActionEvent Event) throws IOException, Exception{



    selectedFile = fileChooser.showOpenDialog(null).getAbsolutePath();
    System.out.println(selectedFile);

    FXMLLoader loader = new FXMLLoader(getClass().getResource("ProgressBar.fxml"));
    Parent root = (Parent) loader.load();

    ProgressBarController pBarController = loader.getController();


    Stage stage = new Stage();
    stage.setScene(new Scene(root));
    stage.show();
    image.imageProperty().bind(pBarController.loadImage2(selectedFile));
}