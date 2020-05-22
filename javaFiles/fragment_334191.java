txtName.addValueChangeHandler ( new ValueChangeHandler<String>() {
  @Override
  public void onValueChange(ValueChangeEvent<String> event) {
    final String name = event.getValue()
    txtMailBox.setText(name);
  }

});