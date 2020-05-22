//Getting a pixel object for the given x and y value
Pixel pixelObj = image.getPixel(x, y);
Pixel oppositePixel = image.getPixel(image.getWidth()-x-1, y);
//Store the RGB values of the opposite pixel temporarily
int redValue = oppositePixel.getRed();
int greenValue = oppositePixel.getGreen();
int blueValue = oppositePixel.getBlue();
//This swaps the color values of the new pixel to the ones of the old pixel
oppositePixel.setRed(pixel0bj.getRed());
oppositePixel.setGreen(pixel0bj.getGreen());
oppositePixel.setBlue(pixel0bj.getBlue());
pixelObj.setRed(redValue);
pixelObj.setGreen(greenValue);
pixelObj.setBlue(blueValue);