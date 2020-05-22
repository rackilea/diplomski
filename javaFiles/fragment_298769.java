public void run() {
    writer.addVideoStream(0, 0, ICodec.ID.CODEC_ID_H264, size.width, size.height);
    try {
        int frameIdx = 0;
        final long start = System.currentTimeMillis();
        while (true) {
            final CapturedFrame capturedFrame = queue.take();
            if (capturedFrame.isEnd()) {
                break;
            }
            final BufferedImage webcamImage = capturedFrame.getImage();
            size.height);

            // convert the image and store
            final IConverter converter = ConverterFactory.createConverter(webcamImage, IPixelFormat.Type.YUV420P);
            final long end = System.currentTimeMillis();
            final IVideoPicture frame = converter.toPicture(webcamImage, (end - start) * 1000);

            frame.setKeyFrame((frameIdx++ == 0));
            frame.setQuality(0);
            writer.encodeVideo(0, frame);
        }
    } catch (final InterruptedException e) {
        System.out.println("### threading issues during image processing:: " + e.getMessage());
    } finally {
        if (writer != null) {
            writer.close();
        }
    }