ImagePlus im = IJ.getImage();
ImageProcessor imp = im.getProcessor();

int[] rgb = new int[3];
imp.getPixel(X,Y,rgb);

IJ.log(Arrays.toString(rgb));