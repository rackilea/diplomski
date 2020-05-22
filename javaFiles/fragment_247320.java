/** Typical scaling implementation using JMagick **/
ImageInfo origInfo = new ImageInfo(absPath); //load image info
MagickImage image = new MagickImage(origInfo); //load image
image = image.scaleImage(finalWidth, finalHeight); //to Scale image
image.setFileName(absNewFilePath); //give new location
image.writeImage(origInfo); //save