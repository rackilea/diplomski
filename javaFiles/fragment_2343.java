class SoundPlayer
{
    // plays an InputStream for a given number of samples, length
    public static void play(InputStream stream, float sampleRate, int sampleSize, int length) throws LineUnavailableException
    {
        // you can specify whatever format you want...I just don't need much flexibility here
        AudioFormat format = new AudioFormat(sampleRate, sampleSize, 1, false, true);
        AudioInputStream audioStream = new AudioInputStream(stream, format, length);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();
    }

    public static void play(InputStream stream, float sampleRate, int sampleSize) throws LineUnavailableException
    {
        AudioFormat format = new AudioFormat(sampleRate, sampleSize, 1, false, true);
        SourceDataLine line = AudioSystem.getSourceDataLine(format);
        line.open(format);
        line.start();
        // if you wanted to block, you could just run the loop in here
        SoundThread soundThread = new SoundThread(stream, line);
        soundThread.start();
    }

    private static class SoundThread extends Thread
    {
        private static final int buffersize = 1024;

        private InputStream stream;
        private SourceDataLine line;

        SoundThread(InputStream stream, SourceDataLine line)
        {
            this.stream = stream;
            this.line = line;
        }

        public void run()
        {
            byte[] b = new byte[buffersize];
            // you could, of course, have a way of stopping this...
            for (;;)
            {
                stream.read(b);
                line.write(b, 0, buffersize);
            }
        }
    }
}