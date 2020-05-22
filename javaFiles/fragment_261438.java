class GifSequenceWriter {
    public GifSequenceWriter(
        ImageOutputStream outputStream,
        int imageType,
        int timeBetweenFramesMS,
        boolean loopContinuously);

    public void writeToSequence(RenderedImage img);

    public void close();
}