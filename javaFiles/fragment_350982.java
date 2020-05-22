FXMLLoader popupLoader = new FXMLLoader(getClass().getResource("Popup.fxml"));
Parent root = (Parent) popupLoader.load();
PopupController popupCont = popupLoader.getController();
popupCont.setMainController(this);      // This passes this controller reference to your popup
popupCont.changeLabel("The Second");
Stage stage = new Stage();
stage.setTitle("Popup Window");
stage.setScene(new Scene(root));
stage.show();