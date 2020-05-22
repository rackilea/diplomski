public void gameRenderLoop() {
    Graphics2D g2 = gameImage.createGraphics();
    g2.drawImage(playerImage, 22, 35, this);
    ...
    g2.dispose();
}