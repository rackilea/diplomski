@Override
public void updateItem(Label item, boolean empty) {
    super.updateItem(item, empty);
    if (item != null && !empty) {
        setText(item.getText());
        setGraphic(item.getGraphic());
    } else {
        setText(null);
        setGraphic(null);
    }
}