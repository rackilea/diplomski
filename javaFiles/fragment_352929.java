public class ListViewModel {

    @Inject
    private Model model ;

    private final StringProperty selectedItem = new SimpleStringProperty();

    public ObservableList<String> getItems() {
        return model.getItemList();
    }

    public StringProperty selectedItemProperty() {
        return selectedItem ;
    }

    public String getSelectedItem() {
        return selectedItemProperty().get();
    }

    public void setSelectedItem(String item) {
        selectedItemProperty().set(item);
    }
}