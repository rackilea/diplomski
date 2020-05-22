public static void setMedia(String path) {

    if (mediaPlayer != null) {
        mediaPlayer.stop();
        mediaPlayer.dispose();
    }
    try {
        musicPlayer = new MediaPlayer(new Media(new File(path).toURI().toASCIIString()));
        musicPlayer.play();
    } catch (Exception e) {
        System.out.println("invald file");
        System.out.println(e.getMessage());
    }
}