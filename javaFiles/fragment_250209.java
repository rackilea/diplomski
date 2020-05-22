chart.layoutBoundsProperty().addListener((observable, oldValue, newValue) -> {
        double textRelativeXz = (newValue.getMinX() + newValue.getMaxX()) / 2 - text.getLayoutBounds().getWidth() / 2;
        double textRelativeYz = newValue.getMinY() - text.getLayoutBounds().getHeight() / 3;

        AnchorPane.setLeftAnchor(text, textRelativeXz);
        AnchorPane.setTopAnchor(text, textRelativeYz);
    });