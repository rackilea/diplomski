public ToggleButton getBuildBtn() {

        final ToggleButton button = new ToggleButton("Build");

        button.setStyle("-fx-font: 15 verdana; -fx-base: " + buttonsColor + ";");
        button.setOnAction(event -> selectedhandler(button, "build"));
        return button;
}

private void selectedhandler(final ToggleButton button, String command) {
    if (button.isSelected()) {
        button.setStyle("-fx-base: #00ff0f;");
        commands.add(command);
    } else {
        button.setStyle("-fx-base: " + buttonsColor + ";");
        commands.remove(command);
    }
}