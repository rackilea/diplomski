public class StreamConsumer implements Runnable {
    private final InputStream input;

    public StreamConsumer(InputStream input) {
        this.input = input;
    }

    @Override
    public void run() {
        byte[] buffer = new byte[1024];
        try {
            while (input.read(buffer) > 0) {
                // No-op; we're not interested in the data
            }
        } catch (IOException e) {
            // Log the error or whatever you want to do. The stream is probably
            // broken now...
        }
    }
}

...

new Thread(new StreamConsumer(proc_ffmpeg.getInputStream())).start();
new Thread(new StreamConsumer(proc_ffmpeg.getErrorStream())).start();