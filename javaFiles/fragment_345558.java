@Override
public ObservableList<Item> getItems() {
    if (!(super.getItems() instanceof ObservableList)) {
        items = FXCollections.observableList(items);
    }
    return (ObservableList<Item>)items;
}