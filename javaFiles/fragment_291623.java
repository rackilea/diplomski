@Override
protected void paintThumb(Graphics g, JComponent c, Rectangle r) {
    g.setColor(Color.blue);
    Graphics2D g2d = (Graphics2D) g;
    g2d.drawImage(imageThumb, r.x, r.y, r.width, r.height, null);
    g2d.setPaint(Color.red);
    g2d.drawRect(r.x, r.y, r.width - 1, r.height);
}