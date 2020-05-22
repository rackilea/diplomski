listenForSelection(rootTreeItem,
        selected -> System.out.println(selected));

// ...

private void listenForSelection(TreeItem<Person> treeItem,
                                Consumer<Boolean> listener) {

    BooleanProperty selected = treeItem.getValue().selectedProperty();

    selected.addListener(
        (obs, oldVal, newVal) -> listener.accept(newVal));

    treeItem.getChildren().forEach(item -> listenForSelection(item, listener));
}