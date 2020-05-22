protected void paintComponent(Graphics g) {
    g.setClip(new Ellipse2D.Double(0, 0, getWidth(), getHeight()));  // set the area that shall be painted
    g.drawImage(bim, 0, 0, getWidth(), getHeight(), null);    // draw the image, if available
    if (getModel().isArmed()) {      // show a slight gray shading when pressing the button
        g.setColor(new Color(127, 127, 127, 80));   // gray with 80 as alpha
        g.fillOval(0, 0, getSize().width - 1, getSize().height - 1);
    }
    super.paintComponent(g);
}