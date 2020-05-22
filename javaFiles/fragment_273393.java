Dialog dialog = new Dialog();
dialog.addDialogHideHandler(new DialogHideHandler() {
  @Override
  public void onDialogHide(DialogHideEvent event) {
    if (event.getHideButton().equals(PredefinedButton.OK)) {
      // user clicks ok
    } else if (event.getHideButton().equals(PredefinedButton.CANCEL)) {
      // user clicks cancel
    }
  }
});