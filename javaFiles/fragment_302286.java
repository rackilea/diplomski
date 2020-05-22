private int compare(byte[] captchaData, byte[] sampleData) throws IOException {
    return new String(captchaData).indexOf(new String(sampleData));
}

private byte[] transform(Path audio) throws IOException, UnsupportedAudioFileException {
    AudioInputStream ais = AudioSystem.getAudioInputStream(audio.toFile());
    AudioFormat format = ais.getFormat();
    try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
        int nBufferSize = 1024 * format.getFrameSize();
        byte[] abBuffer = new byte[nBufferSize];
        int nBytesRead;
        while ((nBytesRead = ais.read(abBuffer)) > -1) {
            baos.write(abBuffer, 0, nBytesRead);
        }
        return baos.toByteArray();
    }
}