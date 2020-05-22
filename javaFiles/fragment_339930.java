button.hoverProperty().addListener((ov, oldValue, newValue) -> {
    if (newValue) {
        button.setText("Hovered");
    } else {
        button.setText("Not Hovered");
    }
});