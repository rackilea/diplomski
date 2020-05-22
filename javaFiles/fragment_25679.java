private void mouseDragged(java.awt.event.MouseEvent evt) {

    color = new Color(sliderRed.getValue(), sliderGreen.getValue(), sliderBlue.getValue());
    this.repaint();
}

public void paint(Graphics g) {

    g.setColor(color)
    g.fillRect(sliderRed.getBounds().x + sliderRed.getBounds().width + 20, sliderRed.getBounds().y, 30, 30);
}