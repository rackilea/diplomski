Platform.runLater(()->{
    Parent root1;
    root1 = FXMLLoader.load(getClass().getResource("Student.fxml"));
    Stage stage = new Stage();
    stage.setTitle("ABC");
    stage.setScene(new Scene(root1));  
    stage.show();
});