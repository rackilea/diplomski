delAnswer.setOnAction(e -> {
    // get button
    Node source = (Node) e.getSource();

    // remove parent of button from VBox
    vBox.getChildren().remove(source.getParent());
});