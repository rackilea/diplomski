ObservableList<Branch> lst = FXCollections.observableArrayList(myMap.keySet());
myMap.addListener(new MapChangeListener<? extends Branch, ? extends Boolean>() {
    @Override
    public void onChanged(Change<? extends Branch, ? extends Boolean> change) {
        boolean removed = change.wasRemoved();
        boolean added = change.wasAdded();
        Branch key = change.getKey();

        if (removed && !added) {
            lst.remove(key);
        }
        if (added && !removed) {
            lst.add(key);
        }
    }
});