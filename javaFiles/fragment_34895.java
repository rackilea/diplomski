final ObservableList<Map<String, Object>> collection = FXCollections.observableArrayList();

tableView.getItems().forEach(item -> {
    final Map<String, Object> itemMap = new HashMap<>();

    tableView.getVisibleLeafColumns().forEach(column -> {
        itemMap.put(column.getText(), column.getCellObservableValue(item).getValue());
    }
    collection.add(itemMap);
});