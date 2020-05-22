File javaStreamSubsample(File inFile, int s, Rectangle sourceRegion) throws IOException  {
    File outFile = File.createTempFile("img", null);;
    ImageInputStream input = ImageIO.createImageInputStream(inFile);
    try {
        Iterator<ImageReader> readers = ImageIO.getImageReaders(input);
        ImageReader reader = readers.next();
        try {
            reader.setInput(input);
            ImageReadParam param = reader.getDefaultReadParam();
            param.setSourceSubsampling(s, s, 0, 0);
            if(sourceRegion!=null){
                param.setSourceRegion(sourceRegion);
            }
            BufferedImage image = reader.read(0, param);
            ImageIO.write(image, "jpg", outFile);
        }finally {
            reader.dispose();
        }
    } finally {
        input.close();
    }
    return outFile;
}