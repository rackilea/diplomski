class DrawCanvas extends Canvas implements ActionListener, MouseListener{
    //...

    public Color getRGBAt(int x, int y) {
        BufferedImage img = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();
        paint(g2d);
        g2d.dispose();
        return new Color(img.getRGB(x, y), true);
    }