private static byte[] buffer = new byte[4096 * 2 / 3];
private static int bufferSize = 0;

// plays a sample in range (-1, +1).
public static void play(SourceDataLine line, double in) {
    if (in < -1.0) in = -1.0;  // just sanity checks
    if (in > +1.0) in = +1.0;

    // convert to bytes - need 2 bytes for 16 bit sample
    short s = (short) (Short.MAX_VALUE * in);
    buffer[bufferSize++] = (byte) s;
    buffer[bufferSize++] = (byte) (s >> 8);   // little Endian

    // send to line when buffer is full
    if (bufferSize >= buffer.length) {
        line.write(buffer, 0, buffer.length);
        bufferSize = 0;
    }
    // todo: be sure that whole buffer is sent to line!
}

// prepares array of doubles, not related with the sampling value!
private static double[] tone(double hz, double duration) {
    double amplitude = 1.0;
    int N = (int) (44100 * duration);
    double[] a = new double[N + 1];
    for (int i = 0; i <= N; i++) {
        a[i] = amplitude * Math.sin(2 * Math.PI * i * hz / 44100);
    }
    return a;
}

// finally:
public static void main(String[] args) throws LineUnavailableException {
    AudioFormat af = new AudioFormat(44100, 16, 1, true, false);
    SourceDataLine sdl = AudioSystem.getSourceDataLine(af);

    sdl.open(af, 4096 * 2);
    sdl.start();

    double[] tones = tone(440, 2.0);    // play A for 2 seconds
    for (double t : tones) {
        play(sdl, t);
    }

    sdl.drain();
    sdl.stop();
    sdl.close();
}