public void playSound(Context context) throws IllegalArgumentException, 
                                              SecurityException, 
                                              IllegalStateException,
                                              IOException {

    Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
    MediaPlayer mMediaPlayer = new MediaPlayer();
    mMediaPlayer.setDataSource(context, soundUri);
    final AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);

    if (audioManager.getStreamVolume(AudioManager.STREAM_ALARM) != 0) {
        mMediaPlayer.setAudioStreamType(AudioManager.STREAM_ALARM);
        // Uncomment the following line if you aim to play it repeatedly
        // mMediaPlayer.setLooping(true);
        mMediaPlayer.prepare();
        mMediaPlayer.start();
    }
}