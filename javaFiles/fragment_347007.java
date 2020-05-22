textArea.textProperty().addListener(new ChangeListener<String>() {

  @Override
  public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
    System.out.print("textArea: ");
    System.out.println(newValue);
  }
});