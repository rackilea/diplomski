AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener =
        new AudioManager.OnAudioFocusChangeListener() {
            public void onAudioFocusChange(int focusChange) {
                if (mMediaPlayer == null)
                    return;
                if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                        focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                    mMediaPlayer.pause();   // <-- Lose audio focus
                    mMediaPlayer.seekTo(0); // <--  & start again because its a short clip
                } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                    mMediaPlayer.start();   // <-- Resume playing media
                } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                    releaseMediaPlayer();   // if audiofocus is lost or app is closed
                    //              stop playback and clean resource.
                }
            }
        };