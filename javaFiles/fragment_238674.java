//set path
mediaPlayer.setDataSource("yourFilePath");
mediaPlayer.setOnPrepareListener(new OnPrepareListener(MediaPlayer mediaPlayer) {
       mediaPlayer.start();
});
mediaPlayer.prepareAsync();