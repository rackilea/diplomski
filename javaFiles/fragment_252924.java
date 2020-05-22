int result = am.requestAudioFocus(afChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED){
    new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {
            player.start();
        }
    }, 100);
}