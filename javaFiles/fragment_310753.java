try {
    BufferedImage base = ImageIO.read(new File("base.jpg"));
    BufferedImage overlay = ImageIO.read(new File("overlay.jpg"));

    Graphics2D g2d = base.createGraphics();
    g2d.setComposite(AlphaComposite.SrcOver.derive(0.5f));
    int x = (base.getWidth() - overlay.getWidth()) / 2;
    int y = (base.getHeight() - overlay.getHeight()) / 2;
    g2d.drawImage(overlay, x, y, null);
    g2d.dispose();

    ImageIO.write(base, "jpg", new File("Blended.jpg"));
} catch (IOException e) {
    e.printStackTrace();
}