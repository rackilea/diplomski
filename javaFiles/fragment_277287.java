Color bgColor = Color.WHITE;

BufferedImage foreground = ImageIO.read(localUrl);
int width = foreground.getWidth();
int height = foreground.getHeight();
BufferedImage background = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
Graphics2D g = background.createGraphics();
g.setColor(bgColor);
g.fillRect(0, 0, width, height);
g.drawImage(foreground, 0, 0, null);
g.dispose();
File outputfile = new File(localUrl.getPath());
ImageIO.write(background, "png", outputfile);