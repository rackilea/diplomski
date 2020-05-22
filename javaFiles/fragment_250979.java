@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (dbImage != null) {
        g.drawImage(dbImage, 0, 0, this);
    }
}