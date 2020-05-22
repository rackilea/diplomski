public void actionPerformed(ActionEvent e) {
    Object source = e.getSource();
    if (source == ranRects) {
        addRect();
    } else if (source == ranElli) {
        addOval();
    } else if (source == ranLines) {
        addLine();
    }
    repaint();
}