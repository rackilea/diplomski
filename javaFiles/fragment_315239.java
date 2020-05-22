public void setSampleFont() {

    if (pCheckBox.isSelected()) {
        total = total + 1.25;
    }
    if (mCheckBox.isSelected()) {
        total = total + 1.10;
    }

    // !! Supply a positive font size //
    double size = 64;
    // A nice style //
    double style = Font.BOLD;

    final double SMALL_SIZE = 5.25;
    final double MEDIUM_SIZE = 7.55;
    final double LARGE_SIZE = 9.35;

    if (smallButton.isSelected()) {
        total = total + SMALL_SIZE;
    } else if (mediumButton.isSelected()) {
        total = total + MEDIUM_SIZE;
    } else if (largeButton.isSelected()) {
        total = total + LARGE_SIZE;
    }

    // Use the JLabel's default font...
    Font font = UIManager.getFont("Label.font");
    // Derive a new font at the required size and style...
    font = font.deriveFont((int)style, (int)size);

    sampleField.setText(totalPrint);
    sampleField.setFont(font);
//        sampleField.repaint();
}