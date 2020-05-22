int width=100,height=75; /* set the width and height here */
BufferedImage inputImage=ImageIO.read(sourceFile);
BufferedImage outputImage=new BufferedImage(width, height,
    BufferedImage.TYPE_INT_RGB);
Graphics2D g=outputImage.createGraphics();
g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
    RenderingHints.VALUE_INTERPOLATION_BICUBIC);
g.clearRect(0, 0, width, height);
g.drawImage(inputImage, 0, 0, width, height, null);
g.dispose();
ImageIO.write(outputImage,"jpg",destFile);
/* first parameter is the object of the BufferedImage,
   second parameter is the type of image that you are going to write,
       you can use jpg, bmp, png etc
   third parameter is the destination file object. */