// Create an image input stream on the image
    ImageInputStream iis = ImageIO.createImageInputStream(o);

    // Find all image readers that recognize the image format
    Iterator iter = ImageIO.getImageReaders(iis);
    if (!iter.hasNext()) {
        // No readers found
        return null;
    }

    // Use the first reader
    ImageReader reader = (ImageReader)iter.next();