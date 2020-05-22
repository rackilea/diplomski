@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (myImage != null) {
        g.drawImage(myImage, 0, 0, null);
    }
}