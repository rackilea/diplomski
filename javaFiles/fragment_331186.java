public void drawMapToImage(File outputFile, String outputType,
        JMapPane mapPane) {
    ImageOutputStream outputImageFile = null;
    FileOutputStream fileOutputStream = null;
    try {
        fileOutputStream = new FileOutputStream(outputFile);
        outputImageFile = ImageIO.createImageOutputStream(fileOutputStream);
        RenderedImage bufferedImage = mapPane.getBaseImage();
        ImageIO.write(bufferedImage, outputType, outputImageFile);
    } catch (IOException ex) {
        ex.printStackTrace();
    } finally {
        try {
            if (outputImageFile != null) {
                outputImageFile.flush();
                outputImageFile.close();
                fileOutputStream.flush();
                fileOutputStream.close();
            }
        } catch (IOException e) {// don't care now
        }
    }
}