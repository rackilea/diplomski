public void forwardSong(MediaPlayer mediaPlayer) {
    int currentPosition = mediaPlayer.getCurrentPosition();
    String tag2 = "currentPosition";
    Log.v(tag2, String.valueOf(mediaPlayer.getCurrentPosition()));
    if (currentPosition + seekForwardTime <= mediaPlayer.getDuration()) {
        mediaPlayer.seekTo(currentPosition + seekForwardTime);
    } else {
        String tag = "main activity";
        Log.v(tag, "else state");
        mediaPlayer.seekTo(mediaPlayer.getDuration());
    }
}