final IMediaWriter writer = ToolFactory.makeWriter(outputFile);
    writer.addVideoStream(0, 0, ICodec.ID.CODEC_ID_H264, img.getSize().width, screenshot.getSize().height);
    long startTime = System.nanoTime();
    for (int i=0; i<seconds*25; i++) {
        BufferedImage bgrScreen = Tools.convertToType(img, BufferedImage.TYPE_3BYTE_BGR);
        writer.encodeVideo(0, bgrScreen, System.nanoTime() - startTime, TimeUnit.NANOSECONDS);
        try {
            Thread.sleep((long) (1000 / 25));
        } catch (InterruptedException e) {
            // ignore
        }
    }
    writer.close();