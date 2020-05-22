private OnAudioFocusChangeListener focusChangeListener = new OnAudioFocusChangeListener() {
    public void onAudioFocusChange(int focusChange) {
        AudioManager am =(AudioManager)getSystemService(Context.AUDIO_SERVICE);
        switch (focusChange) {
            case (AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) :
                // Lower the volume while ducking.
                mediaPlayer.setVolume(0.2f, 0.2f);
                break;
            case (AudioManager.AUDIOFOCUS_LOSS_TRANSIENT) :
                pause();
                break;
            case (AudioManager.AUDIOFOCUS_LOSS) :
                stop();
                ComponentName component =new ComponentName(AudioPlayerActivity.this,MediaControlReceiver.class);
                am.unregisterMediaButtonEventReceiver(component);
                break;
            case (AudioManager.AUDIOFOCUS_GAIN) :
                // Return the volume to normal and resume if paused.
                mediaPlayer.setVolume(1f, 1f);
                mediaPlayer.start();
                break;
            default: break;
        }
    }
};