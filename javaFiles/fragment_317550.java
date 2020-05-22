rootTreeItem.getChildren().forEach(item -> {
    BooleanProperty selected = item.getValue().selectedProperty();

    selected.addListener((obs, oldVal, newVal) -> {
        System.out.println(newVal);
    });
});