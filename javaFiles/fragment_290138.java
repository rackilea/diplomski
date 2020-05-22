private BufferedImage img;

public void load(String path) throws IOException {
       img = ImageIO.read(new File(path));
       this.repaint();
}

@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (img != null) {
        g.drawImage(img, 0, 0, null);
    }
}