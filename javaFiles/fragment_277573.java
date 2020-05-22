public void update() {
    x -= dx;
    if (x<-GamePanel.WINDOW_WIDTH) {
        x+=GamePanel.WINDOW_WIDTH; 
        // or reset to zero
    }
}

public void draw(Graphics2D g) {

    // 1st image
    g.drawImage(image, (int) x, (int) y, GamePanel.WINDOW_WIDTH, GamePanel.WINDOW_HEIGHT, null);

    // 2nd image right to 1st image
    g.drawImage(image, (int) x + GamePanel.WINDOW_WIDTH, (int) y, GamePanel.WINDOW_WIDTH, GamePanel.WINDOW_HEIGHT, null);

}// End of draw method