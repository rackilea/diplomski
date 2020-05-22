private MediaPlayer mediaPlayer;

private void playSong(String filePath) {
    if (mediaPlayer != null && mediaPlayer.isPlaying()){
        mediaPlayer.stop();
    }

    mediaPlayer = MediaPlayer.create(getActivity(), Uri.parse(filePath));
    mediaPlayer.setVolume(DEFAULT_VOLUME_MUSIC, DEFAULT_VOLUME_MUSIC);
    mediaPlayer.start();
    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {

        }
    });
}