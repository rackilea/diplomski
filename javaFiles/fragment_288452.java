@Override
protected void updateItem(Friend item, boolean empty) {
    Friend oldItem = getItem();
    if (oldItem != null) {
        oldItem.messageCountProperty().removeListener(listener);
    }

    super.updateItem(item, empty);

    if (empty || item == null) {
        setText("");
        updateMessageCount(0);
    } else {
        setText(item.getName());
        item.messageCountProperty().addListener(listener);
        updateMessageCount(item.getMessageCount());
    }

}