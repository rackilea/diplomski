...
mediaPlayer.setOnError(()-> {
  (code to create temp file ...)
  Media media = new Media(<tempfile>);
  mediaPlayer = new MediaPlayer(media);
  mediaPlayer.play();
});
mediaPlayer.play();