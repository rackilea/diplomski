Image image1 = img1.getImage(); 
Image image2  = img2.getImage();
int w = image1.width + image2.width;
int h = Math.max(image1.height, image2.height);
Image image = new BufferedImage(w, h,  TYPE_INT_RGB);
Graphics2D g2 = image.createGraphics();
g2.drawImage(image1, 0, 0, null);
g2.drawImage(image2, image1.width, 0, null);
g2.dispose();

ImageIcon newImg = new ImageIcon(image);