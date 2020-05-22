// draw within the paintComponent method, not the paint method
@Override
protected void paintComponent(Graphics g) {
    // call the super's method to all painting to chain down the line
    super.paintComponent(g);
    if (dbimage != null) {
        g.drawImage(dbimage, imgX, imgY, this);
    }
}