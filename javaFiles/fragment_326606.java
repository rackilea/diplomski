AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(DragonflyApp.class.getResource("/resources/" + soundFile));
clip = AudioSystem.getClip();
clip.addLineListener(e -> {
    if (e.getType() == LineEvent.Type.STOP) {
        // Do something on end of playback
    }
});
clip.open(audioInputStream);
clip.start();