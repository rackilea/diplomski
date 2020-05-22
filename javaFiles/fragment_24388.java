dialog.getButtonById(PredefinedButton.OK.name()).addSelectHandler(new SelectHandler() {
  @Override
  public void onSelect(SelectEvent event) {
    if (netScanName.getValue() == null) {
      Util.alert("All fields are required!");
    } else {
      dialog.hide();
    }
  }
});