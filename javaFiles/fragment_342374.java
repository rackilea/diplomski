private byte[] record() throws LineUnavailableException {
    AudioFormat format = AudioUtil.getAudioFormat(audioConf);
    DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);

    // Checks if system supports the data line
    if (!AudioSystem.isLineSupported(info)) {
        return null;
    }

    microphone = (TargetDataLine) AudioSystem.getLine(info);
    microphone.open(format);
    microphone.start();

    System.out.println("Listening, tap enter to stop ...");

    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    int numBytesRead;
    byte[] data = new byte[microphone.getBufferSize() / 5];
    short[] shorts = new short[data.length / 2];
    long startSilence = 0;
    boolean pause = false;

    // Begin audio capture.
    microphone.start();

    // Here, stopped is a global boolean set by another thread.
    while (!stopped) {
        // Read the next chunk of data from the TargetDataLine.
        numBytesRead = microphone.read(data, 0, data.length);
        ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().get(shorts);

        // Save this chunk of data.
        byteArrayOutputStream.write(data, 0, numBytesRead);

        double rms = 0;
        for (int i = 0; i < shorts.length; i++) {
            double normal = shorts[i] / 32768f;
            rms += normal * normal;
        }
        rms = Math.sqrt(rms / shorts.length);
        System.out.println("Listening, rms is " + rms);
        if (rms < 0.1) {
            long now = System.currentTimeMillis();
            if (now - startSilence > 5000 && pause)
                break;
            if (!pause) {
                startSilence = now;
                System.out.println("Listening, new silence at " + startSilence);
            }
            pause = true;
        } else
            pause = false;
    }

    return byteArrayOutputStream.toByteArray();
}