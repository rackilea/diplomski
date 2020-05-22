int MAX_LEN = 10;

TextField.addDataChangeListener(new DataChangedListener() {

  public void dataChanged(int type, int index) {

    if(TextField.getText().length() > MAX_LEN ) {
    TextField.setText(TextField.getText().substring(0, MAX_LEN ));

  }
}