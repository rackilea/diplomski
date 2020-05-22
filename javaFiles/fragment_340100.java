public void openModal() throws IOException {
    Stage primaryStage = new Stage();
    FXMLLoader loader = new FXMLLoader(getClass().getResource("sec.fxml"));
    Parent root = loader.load();
    primaryStage.setTitle("Send Mail");
    primaryStage.setScene(new Scene(root,800,600));
    primaryStage.initModality(Modality.WINDOW_MODAL);
    //primaryStage.initOwner((Stage) menuBar.getScene().getWindow());

    loader.<Sec>getController().setController(this);
    primaryStage.show();
}