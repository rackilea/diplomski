//Draws the image to the ClockFace panel
@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D twoD = (Graphics2D) g;
    twoD.drawImage(clockFace, 0, 0, null);

}