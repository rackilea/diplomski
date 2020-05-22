AudioInputStream ais = null;
try {
    File file = new File(...);
    ais = AudioSystem.getAudioInputStream(file);
    format = ais.getFormat();
    frameCount = ais.getFrameLength();
    duration = ((double) frameCount) / format.getFrameRate();

    clip = AudioSystem.getClip();
    clip.open(ais);
} catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
    ex.printStackTrace();
}