AudioManager.OnAudioFocusChangeListener focusChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                public void onAudioFocusChange(int focusChange) {
                    AudioManager am = (AudioManager) 
getSystemService(AUDIO_SERVICE);
                    switch (focusChange) {

                        case 
(AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK):
                            // Lower the volume while ducking.
                            player.setVolume(0.2f, 0.2f);
                            break;
                        case (AudioManager.AUDIOFOCUS_LOSS_TRANSIENT):
                            player.pause();
                            break;

                        case (AudioManager.AUDIOFOCUS_LOSS):
                            player.stop();
                            break;

                        case (AudioManager.AUDIOFOCUS_GAIN):

                            player.setVolume(1f, 1f);

                            break;
                        default:
                            break;
                    }
                }
            };

    AudioManager am = (AudioManager) getSystemService(AUDIO_SERVICE);

// Request audio focus for playback
    int result = am.requestAudioFocus(focusChangeListener,
// Use the music stream.
            AudioManager.STREAM_MUSIC,
// Request permanent focus.
            AudioManager.AUDIOFOCUS_GAIN);


    if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
        player.setSource(video);

    }