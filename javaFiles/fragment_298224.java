table1.setCellValueFactory(data -> {
    List<String> rowValues = data.getValue();
    int index = objectList.indexOf(c);
    return index >= 0 && index < rowValues.size()
                 ? new SimpleStringProperty(rowValues.get(index)) // does just the same as ReadOnlyStringWrapper in this case
                 : null; // no value, if outside of valid index range
});