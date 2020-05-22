@Override
public void updateItem(SomeType item, boolean empty) {
    super.updateItem(item, boolean);
    if (empty) {
        setText(null);
        setGraphic(null);
    } else {
        // configure cell...
    }
}