public class Controller {

    private ListProperty<String> choiceBoxItems = new SimpleListProperty(FXCollections.observableArrayList());

    public Controller() {
        IntStream.range(1,10).mapToObj(i -> Integer.toString(i))
            .forEach(choiceBoxItems::add);
    }

    public ListProperty<String> choiceBoxItemsProperty() {
        return choiceBoxItems ;
    }

    public ObservableList<String> getChoiceBoxItems() {
        return choiceBoxItemsProperty().get() ;
    }

    public void setComboBoxItems(ObservableList<String> choiceBoxItems) {
        choiceBoxItemsProperty().set(choiceBoxItems) ;
    }

    // ...
}