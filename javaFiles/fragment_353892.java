BufferedImage originalImage = readImage(inputFileLocation);

/**
* Image Cropping Parameters
*/
int cropHeight = 600;
int cropWidth = 600;
int cropStartX = 50;
int cropStartY = 50;

BufferedImage processedImage = cropMyImage(originalImage, cropWidth,
cropHeight, cropStartX, cropStartY);