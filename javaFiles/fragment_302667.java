final ColorPicker colorPicker = new ColorPicker(Color.CYAN);
colorPicker.setOnAction(e -> {
    Color color = colorPicker.getValue();
    String hex = String.format("#%02x02x02x",
        (int) (color.getRed() * 255),
        (int) (color.getGreen() * 255),
        (int) (color.getBlue() * 255));

    Text.setText(hex);
    ShortcutButton.setBackground(
        new Background(new BackgroundFill(color, null, null)));
});

myLayoutPane.getChildren().add(colorPicker);