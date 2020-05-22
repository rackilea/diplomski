@Override protected void updateItem(Boolean item, boolean empty) {
  super.updateItem(item, empty);
  if (empty) {
    setGraphic(null);
  } else {
    setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
    setGraphic(paddedButton);
  }
}