@Override
protected void updateItem(Boolean t, boolean empty) {
    super.updateItem(t, empty);
    if(empty){
        setGraphic(null);
    } else {
        setGraphic(cellButton);
    }
}