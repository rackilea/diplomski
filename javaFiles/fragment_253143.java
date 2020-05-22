public void paint(Graphics g) {
    // You must call super.paint somewhere here...

    Graphics2D g2 =(Graphics2D) g;
    g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC)); // SRC_ATOP > Windows
    g2.drawImage(image, 0, 0, this);
    panel.update(panel.getGraphics());

}