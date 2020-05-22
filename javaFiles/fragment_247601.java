button.setOnAction(event -> {
            final Node node = titledPane.lookup(".title");
            if (button.isSelected()) {
                node.setStyle("-fx-background-color:#00ff11;");
            } else {
                node.setStyle(null);
            }
        });