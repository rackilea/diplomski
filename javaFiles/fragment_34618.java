Image[] images = new Image[5];
int imageIndex = 0;
// fill the array with images

protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(images[imageIndex], ...);
}