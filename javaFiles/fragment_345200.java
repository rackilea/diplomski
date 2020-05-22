stage.initStyle(StageStyle.UNDECORATED);
stage.initStyle(StageStyle.TRANSPARENT);

FXMLLoader loader = new FXMLLoader(
  getClass().getResource(
    "fxml_tableview.fxml"
  )
);

stage.setScene(
  new Scene(
    (Parent) loader.load()
  )
);

FXMLTableViewController controller = 
  loader.<FXMLTableViewController>getController();
controller.registerStage(stage);

stage.show();