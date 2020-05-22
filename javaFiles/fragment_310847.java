String imagePath = "C:\\path\\to\\image.jpg";
java.awt.Image awtImage = ImageIO.read(new File(imagePath));

// scale image here
int scaledWidth = awtImage.getWidth(null) / 2;
int scaledHeight = awtImage.getHeight(null) / 2;
BufferedImage scaledAwtImage = new BufferedImage(scaledWidth, scaledHeight, BufferedImage.TYPE_INT_RGB);
Graphics2D g = scaledAwtImage.createGraphics();
g.drawImage(awtImage, 0, 0, scaledWidth, scaledHeight, null); 
g.dispose();

/* 
Optionally pick a color to replace with transparency.
Any pixels that match this color will be replaced by tansparency.
*/
Color bgColor = Color.WHITE;

Image itextImage = new Image(ImageDataFactory.create(scaledAwtImage, bgColor));