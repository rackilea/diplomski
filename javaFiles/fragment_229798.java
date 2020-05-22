String path = "C:\\Users\\xxx\\Desktop\\a.png";
    BufferedImage image = ImageIO.read(new File(path));
    image = resizeImage(image, image.getWidth() + 100, image.getHeight());  // here you replace the image with the new, resized image from your method
    Graphics graphics = image.getGraphics();
    graphics.setColor(Color.BLACK);
    ....