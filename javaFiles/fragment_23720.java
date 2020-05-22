Clip clip;

private void doPlay(final String url) {
    try {
        stopPlay();
        AudioInputStream inputStream = AudioSystem
                .getAudioInputStream(getClass().getResourceAsStream(url));
        clip = AudioSystem.getClip();
        clip.open(inputStream);
        clip.start();
    } catch (Exception e) {
        stopPlay();
        System.err.println(e.getMessage());
    }
}

private void stopPlay() {
    if (clip != null) {
        clip.stop();
        clip.close();
        clip = null;
    }
}