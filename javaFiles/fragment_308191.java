File f = generateJPG();

BufferedImage image = ImageIO.read(f);

File out = new File("C:/fileJPG.jpg");

ImageIO.write(image, "jpg", out);