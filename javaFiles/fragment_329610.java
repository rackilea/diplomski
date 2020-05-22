public void actionPerformed(ActionEvent e) {
    Object source = e.getSource();
    if (source == ranRects) {
        this.numberOfRects++;
    } else if (source == ranElli) {
        this.numberOfEllis++;
    } else if (source == ranLines) {
        this.numberOfLines++;
    }
    repaint();
}