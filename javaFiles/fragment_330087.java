private static void initFxLater(JFXPanel panel) {
    MediaPlayer mediaPlayer = new MediaPlayer(new Media(MEDIA_URL));
    mediaPlayer.setAutoPlay(true);

    MediaView mediaView = new MediaView(mediaPlayer);
    mediaView.setFitWidth(450);
    mediaView.setFitHeight(200);

    panel.setScene(new Scene(new MediaControl(mediaPlayer));
}