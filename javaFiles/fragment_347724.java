BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
g = image.createGraphics();  // not sure on this line, but this seems more right
g.setColor(Color.white);
g.fillRect(0, 0, 100, 100); // give the whole image a white background
g.setColor(Color.blue);
for( ..... ){
    g.fillRect(X , Y,  width , height );
        ....        
}