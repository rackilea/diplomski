public class Controller {

  @FXML
  TextArea textArea;

  private StringProperty toBind = new SimpleStringProperty();

  public void initialize() {
    textArea.textProperty().bindBidirectional(toBind);

    textArea.textProperty().addListener((observable, oldValue, newValue) -> {
      System.out.print("textArea: ");
      System.out.println(newValue);
    });

    toBind.addListener((observable, oldValue, newValue) -> {
      System.out.print("toBind: ");
      System.out.println(newValue);
    });

  }

  public StringProperty boundProperty() {
      return toBind ;
  }
}