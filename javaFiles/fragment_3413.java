BufferedImage img = ImageIO.read(new File("filePath.png"));

int sRbgColor = img.getRGB(int x, int y);

Color c = new Color(sRbgColor);
int red = c.getRed();
int green = c.getGreen();
int blue = c.getBlue();