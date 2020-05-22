Pane myPane = FXMLLoader.load(getClass().getResource("BreakoutFXML.fxml"));

// 1
game.getScene().getRoot().add(myPane);
// 2
game.getScene().setRoot(myPane);
// 3
game.getStage().setScene(new Scene(myPane));