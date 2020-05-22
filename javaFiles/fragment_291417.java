public class SecondController {
  private StringProperty text  = new SimpleStringProperty(this, "text", "");
  // Remove any reference to FirstController
  //FirstController firstController = new FirstController();
  private ObservableList<String> strArray = FXCollections.observableArrayList();

  @FXML
  private TextArea textArea2 ;
  public StringProperty textProperty() {
    return text ;
  }
  public final String getText2() {
    return text.get();
  }
  public final void setText(String text) {
    this.text.set(text);
  }
  public ObservableList<String> getStrArray() {
    return strArray ;
  }

  // ...

  @FXML 
  private void showTextAction(ActionEvent event) {
    text.set(textArea2.getText()); 
    System.out.println(firstController.strArray); // this line prints empty array []

    System.out.println(firstController.strArray.toString()); // this will result NullPointerException because the array is empty. But why it is empty?
  }
}