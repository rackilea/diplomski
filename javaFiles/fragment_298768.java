public void run() {
    try {
        System.out.println("## capturing images began");
        while (true) {
            final BufferedImage webcamImage = ConverterFactory.convertToType(webcam.getImage(),
                    BufferedImage.TYPE_3BYTE_BGR);
            final Date timeOfCapture = new Date();
            queue.put(new CapturedFrame(webcamImage, timeOfCapture, false));
            if (stopper.isStop()) {
                System.out.println("### signal to stop capturing images received");
                queue.put(new CapturedFrame(null, null, true));
                break;
            }
        }
    } catch (InterruptedException e) {
        System.out.println("### threading issues during recording:: " + e.getMessage());
    } finally {
        System.out.println("## capturing images end");
        if (webcam.isOpen()) {
            webcam.close();
        }
    }
}