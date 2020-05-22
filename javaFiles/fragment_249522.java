private BufferedImage image;

    URL url = getClass().getResource("/mytexture.png");
    assert url != null;
    image =  ImageIO.read(url);

@Override
public void paintComponent(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;
    Rectangle rect = new Rectangle(0, 0, width, height);
    Rectangle textureRect = new Rectangle(0, 0, image.getWidth(), image.getHeight());
    TexturePaint paint = new TexturePaint(image, textureRect);
    g2.setPaint(paint);
    g2.fill(rect);        
}