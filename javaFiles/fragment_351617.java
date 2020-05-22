File file = new File("...");
    AudioInputStream ais = null;
    try {
        ais = AudioSystem.getAudioInputStream(file);
        int frameLength = (int) ais.getFrameLength();
        int frameSize = (int) ais.getFormat().getFrameSize();
        byte[] eightBitByteArray = new byte[frameLength * frameSize];

        int result = ais.read(eightBitByteArray);

        int channels = ais.getFormat().getChannels();
        int[][] samples = new int[channels][frameLength];

        int sampleIndex = 0;
        for (int t = 0; t < eightBitByteArray.length;) {
            for (int channel = 0; channel < channels; channel++) {
                int low = (int) eightBitByteArray[t];
                t++;
                int high = (int) eightBitByteArray[t];
                t++;
                int sample = getSixteenBitSample(high, low);
                samples[channel][sampleIndex] = sample;
            }
            sampleIndex++;
        }

    } catch (Exception exp) {

        exp.printStackTrace();

    } finally {

        try {
            ais.close();
        } catch (Exception e) {
        }

    }

//...

protected int getSixteenBitSample(int high, int low) {
    return (high << 8) + (low & 0x00ff);
}