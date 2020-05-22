public class AddItemViewModel {

    @Inject 
    private Model model ;

    private final StringProperty currentItem = new SimpleStringProperty();

    private final Runnable addItemAction = this::addItem ;

    public StringProperty currentItemProperty() {
        return currentItem ;
    }

    public String getCurrentItem() {
        return currentItemProperty().get();
    }

    public void setCurrentItem(String item) {
        currentItemProperty().set(item);
    }

    public Runnable getAddItemAction() {
        return addItemAction ;
    }

    private void addItem() {
        model.getItemList().add(getCurrentItem());
        setCurrentItem("");
    }
}