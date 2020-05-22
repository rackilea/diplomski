JColorChooser colorChooser = new JColorChooser(java.awt.Color.CYAN);

SwingNode colorChooserNode = new SwingNode();
colorChooserNode.setContent(colorChooser);

Alert dialog = new Alert(Alert.AlertType.NONE);
// Guarantees dialog will be above (and will block input to) mainStage.
dialog.initOwner(mainStage);
dialog.setTitle("Select a color");

dialog.getDialogPane().setContent(colorChooserNode);

dialog.getDialogPane().getButtonTypes().setAll(
    ButtonType.OK, ButtonType.CANCEL);

Optional<ButtonType> response = dialog.showAndWait();
if (response.filter(r -> r == ButtonType.OK).isPresent()) {
    int rgb = colorChooser.getColor().getRGB();
    String hex = String.format("#%06x", rgb & 0xffffff);

    Text.setText(hex);
    ShortcutButton.setBackground(new Background(
        new BackgroundFill(Color.valueOf(hex), null, null)));
} else {
    System.out.println("User canceled");
}