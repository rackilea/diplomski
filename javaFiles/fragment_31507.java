Iterator<ImageReader> it=ImageIO.getImageReaders(iis);
ImageReader reader = null;
if (it.hasNext()) {
    reader = it.next();
}
//you probably want to check for null here to make sure there was one element