public void run() {
    try {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("mysound.mp3"));
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}