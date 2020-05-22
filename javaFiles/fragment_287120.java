public void paint(Graphics g) {
    Dimension size = getSize();
    Insets insets = getInsets();
    int available = size.width - insets.left - insets.right;
    // Draw stuff. Remember to offset by insets.left and insets.top!
    ...
}