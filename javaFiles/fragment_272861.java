final Image image = new Image(display, 1, 1);
e.gc.copyArea(image, x, y);

ImageData data = image.getImageData();

int pixelValue = imageData.getPixel(0,0);

PaletteData palette = data.palette; 
RGB rgb = palette.getRGB(pixelValue); 
System.out.println("RGB value for (x,y): " + rgb);