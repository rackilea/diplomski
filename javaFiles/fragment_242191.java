BufferedImage image[] = new BufferedImage[numImages];
for (int i = 0; i < numImages; i++) {
    SeekableStream ss = new FileSeekableStream(input_dir + file[i]);
    ImageDecoder decoder = ImageCodec.createImageDecoder("tiff", ss, null);
    PlanarImage op = new NullOpImage(decoder.decodeAsRenderedImage(0), null, null, OpImage.OP_IO_BOUND);
    image[i] = op.getAsBufferedImage();
}