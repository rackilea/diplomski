public void createAStage(String foo){ 
     AnchorPane pane = new AnchorPane();
     Stage stage = new Stage();
     Scene scene = new Scene(pane);
     stage.setScene(scene);
     //here we populate the pane with a Label
     //and set that Label again to some value that was passed to this method(foo):
     pane.getChildren().add(new Label(foo));
     stage.show();
}