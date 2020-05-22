button.setOnAction(event -> {
            final Node node = titledPane.lookup(".title");
            if (button.isSelected()) {
                node.setStyle("-fx-color:#00ff11;");
            } else {
                node.setStyle(null);
            }
        });

// In css file  
.titled-pane > .title {
    -fx-color: -primary-border-color;
    -fx-background-insets: 0;
    -fx-background-radius: 0 0 0 0;
    -fx-padding: 0.2em 0.2em 0.2em 0.2em;
}