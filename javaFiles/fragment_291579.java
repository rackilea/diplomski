try (ByteArrayOutputStream os = new ByteArrayOutputStream();
        ImageOutputStream ios = ImageIO.createImageOutputStream(os)) {
    BufferedImage img = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.BITMASK);
    Graphics g = img.createGraphics();
    icon.paintIcon(null, g, 0, 0);
    g.dispose();
    ImageIO.write(img, "png", ios);
    byte[] bytes = os.toByteArray();
    String data = Base64.getEncoder().encodeToString(bytes);
    System.out.println(data);
} catch (IOException e) {
    e.printStackTrace();
}