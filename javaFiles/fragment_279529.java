final BufferedImage image1 = ImageIO.read(new File("C:/results/image.jpg"));
final BufferedImage image2 = ImageIO.read(new File("C:/results/barcode.jpg"));

Graphics g = image2.getGraphics();
g.drawImage(image2, 0, 0, image2.getWidth(), image2.getHeight(), null);
g.dispose();

final int xMax = image1.getWidth() - image2.getWidth();
final int yMax = image1.getHeight() - image2.getHeight();

Graphics g2 = image1.getGraphics();
Random random = new Random();
int x = random.nextInt(xMax);
int y = random.nextInt(yMax);

g2.drawImage(image2, x, y, null);
g2.dispose();

File outputfile = new File("C:/results/final.jpg");
ImageIO.write(image1, "png", outputfile);