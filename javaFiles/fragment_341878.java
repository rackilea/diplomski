@Override
public void paintComponent(Graphics g) {
    BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    Graphics2D gbi = result.createGraphics();
    BufferedImage x = null;
    try {
        x = ImageIO.read(getClass().getResource("/resources/someimage.png"));
    } catch (IOException ex) {
        Logger.getLogger(CanvasPanel.class.getName()).log(Level.SEVERE, null, ex);
    }
    gbi.drawImage(x, 0, 0, this);
    gbi.setColor(selectedColor);
    gbi.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.75f));
    gbi.fillRect(0, 0, width, height);
    g.drawImage(result, 0, 0, this);
}