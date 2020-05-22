if (!isMute) {
        AudioManager mAudioManager = (AudioManager) activity.getSystemService(Context.AUDIO_SERVICE);
        currentVolume = mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        isMute = true;
        mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, 0, 0);
        imageButtonMute.setImageDrawable(getResources().getDrawable(R.mipmap.mute_off));
     } else {

 imageButtonMute.setImageDrawable(getResources().getDrawable(R.mipmap.mute));
      AudioManager mAudioManager = (AudioManager) 
      activity.getSystemService(Context.AUDIO_SERVICE);
     isMute = false;                       
     mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, currentVolume, 0);
    }