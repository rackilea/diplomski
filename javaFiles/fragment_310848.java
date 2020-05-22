String imagePath = "C:\\path\\to\\image.jpg";
java.awt.Image awtImage = ImageIO.read(new File(imagePath));

// scale image here
int scaledWidth = awtImage.getWidth(null) / 2;
int scaledHeight = awtImage.getHeight(null) / 2;
BufferedImage scaledAwtImage = new BufferedImage(scaledWidth, scaledHeight, BufferedImage.TYPE_INT_RGB);
Graphics2D g = scaledAwtImage.createGraphics();
g.drawImage(awtImage, 0, 0, scaledWidth, scaledHeight, null); 
g.dispose();

ByteArrayOutputStream bout = new ByteArrayOutputStream()
ImageIO.write(scaledAwtImage, "jpeg", bout);
byte[] imageBytes = bout.toByteArray();

Image itextImage = new Image(ImageDataFactory.create(imageBytes));