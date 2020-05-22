if (empty || item == null || listObject == null) {
    setText("");
    setStyle("");
} else {
    setStyle(listObject.getIsDummy() ? "-fx-background-color: yellow" : "");
    setText(listObject.getTaskName());
}