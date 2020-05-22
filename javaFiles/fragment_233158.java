static {
    JFXPanel fxPanel = new JFXPanel();
}

private static void playSound(String sound){
    // cl is the ClassLoader for the current class, ie. CurrentClass.class.getClassLoader();
    URL file = cl.getResource(sound);
    final Media media = new Media(file.toString());
    final MediaPlayer mediaPlayer = new MediaPlayer(media);
    mediaPlayer.play();
}