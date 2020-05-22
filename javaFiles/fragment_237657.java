@DefaultProperty("strings")
public class CustomControl extends HBox {
 ChoiceBox<String> choiceBox = new ChoiceBox();
 public ObservableList<String> getStrings() {
  return stringsProperty().get();
 }
 public void setStrings(ObservableList<String> strings) {
  stringsProperty().set(strings);
 }
 public ObjectProperty<ObservableList<String>> stringsProperty() {
  return choiceBox.itemsProperty();
 }
}