// load an image
Image image = javax.imageio.ImageIO.read(new File("someimage.png");
// resize it
image = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
// create a new image to render to
BufferedImage newimg = new BufferedImage(200,100,BufferedImage.TYPE_INT_ARGB);
// get graphics to draw..
Graphics2D graphics =newimg.createGraphics();
//draw the other image on it
graphics.drawImage(image,0,0,null);
graphics.drawImage(image,100,0,null);
graphics.fillOval(20,20,40,40); //making it a bit ugly ;)
//export the new image
ImageIO.write(newimg,"png",new File("output.png"));
//done!