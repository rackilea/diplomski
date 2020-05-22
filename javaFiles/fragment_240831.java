Thread t = new Thread() {
    public void run() {
        try {

            int sound = (440 * 100);        // play A
            AudioFormat af = new AudioFormat(44100, 16, 1, true, false);
            SourceDataLine sdl;
            sdl = AudioSystem.getSourceDataLine(af);
            sdl.open(af, 4096 * 2);
            sdl.start();

            int maxi = (int) (1000 * (float) sound / 1000); // should not depend on notes frequency!
            byte[] buf = new byte[maxi * 2];   // try to find better len!
            int i = 0;
            while (i < maxi * 2) {
                // formula is changed to be simple sine!!
                double val = Math.sin(Math.PI * i * 440 / 44100);
                short s = (short) (Short.MAX_VALUE * val);
                buf[i++] = (byte) s;
                buf[i++] = (byte) (s >> 8);   // little endian
            }
            sdl.write(buf, 0, maxi);
            sdl.drain();
            sdl.stop();
            sdl.close();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }
};

t.start();