// Option add new leaf
CONTEXT_MENU.getNewLeaf().setOnAction(event -> {
  popup = new JFXPopup();
  try {
    popup.setPopupContent((Region) UTIL
        .getPopupView(UTIL.getView("view/application/popup/FormTest.fxml"), popup));
  } catch (IOException e) {
    e.printStackTrace();
  }
  popup.setAutoFix(true);
  // Width & height of the popup
  double width = GLOBALS.getPrimaryStage().getScene().getWidth() / 1.5;
  double height = GLOBALS.getPrimaryStage().getScene().getHeight() / 1.5;
  popup.getPopupContent().setPrefWidth(width);
  popup.getPopupContent().setPrefHeight(height);
  // X & y axis of the popup
  double anchorX = (GLOBALS.getPrimaryStage().getScene().getWidth() - width) / 2;
  double anchorY = (GLOBALS.getPrimaryStage().getScene().getHeight() - height) / 2;
  popup.show(ROOT_PANE, JFXPopup.PopupVPosition.TOP, JFXPopup.PopupHPosition.LEFT, anchorX,
      anchorY);
  item.getChildren().add(new TreeItem<>(new Twitter()));
  CONTEXT_MENU.freeActionListeners();
});