public byte[] createImage() throws Exception {

    ImageWriter iw = ImageIO.getImageWritersByFormatName("gif").next();

    ByteArrayOutputStream os = new ByteArrayOutputStream();
    ImageOutputStream ios = ImageIO.createImageOutputStream(os);
    iw.setOutput(ios);
    iw.prepareWriteSequence(null);
    int i = 0;

    for (AnimationFrame animationFrame : frameCollection) {

        BufferedImage src = animationFrame.getImage();
        ImageWriteParam iwp = iw.getDefaultWriteParam();
        IIOMetadata metadata = iw.getDefaultImageMetadata(
            new ImageTypeSpecifier(src), iwp);

        configure(metadata, "" + animationFrame.getDelay(), i);

        IIOImage ii = new IIOImage(src, null, metadata);
        iw.writeToSequence(ii, null);
        i++;
    }

    iw.endWriteSequence();
    ios.close();
    return os.toByteArray();
}