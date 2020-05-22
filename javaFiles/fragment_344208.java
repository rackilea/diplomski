@Override
protected void updateItem(Float item, boolean empty) {
    super.updateItem(item, empty);

    setText(item == null ? "" : String.format("%.2f", item.floatValue()));

    if(item == null) {
        setStyle(null);
    } else {
        setStyle("-fx-background-color: " + (getTableRow().getItem().getType() == Type.ENTRY ? "#93C572" : "#CC0000" ));
    }
}