try (InputStream stream = url.openStream()) {
    // The "useCache" setting will decide whether "input" below 
    // will be disk or memory cached
    try (ImageInputStream input = ImageIO.createImageInputStream(stream)) {
         ImageReader reader = ImageIO.getImageReaders(input).next(); // TODO: Handle no reader
         try {
             reader.setInput(input);

             // Get dimensions of first image in the stream, without decoding pixel values
             int width = reader.getWidth(0);
             int height = reader.getHeight(0);
         }
         finally {
             reader.dispose();
         }
    }
 }