public class WebcamRecorder {

    final Dimension size = WebcamResolution.QVGA.getSize();
    final Stopper stopper = new Stopper();

    public void startRecording() throws Exception {

        final Webcam webcam = Webcam.getDefault();
        webcam.setViewSize(size);
        webcam.open(true);

        final BlockingQueue<CapturedFrame> queue = new LinkedBlockingQueue<CapturedFrame>();
        final Thread recordingThread = new Thread(new RecordingThread(queue, webcam, stopper));
        final Thread imageProcessingThread = new Thread(new ImageProcessingThread(queue, size));

        recordingThread.start();
        imageProcessingThread.start();
    }

    public void stopRecording() {
        stopper.setStop(true);
    }

}