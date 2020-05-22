rect.setOnMouseClicked(event -> {
    Color curFill = rect.getFill();
    if (Color.ORANGE.equals(curFill) {
        rect.setColor(Color.PINK);
    } else if (Color.PINK.equals(curFill)) {
        rect.setColor(Color.ORANGE);
    } else {
        // Shouldn't end up here if colors stay either Pink or Orange
    }
});