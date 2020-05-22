Ringtone ringtone = Utilities.getRingtone(this)
AudioManager audioManager = Utilities.getAudioManager(this);

int volume = audioManager.getStreamMaxVolume(AudioManager.STREAM_ALARM);

audioManager.setStreamVolume(AudioManager.STREAM_ALARM, volume, AudioManager.FLAG_REMOVE_SOUND_AND_VIBRATE);

ringtone.setStreamType(AudioManager.STREAM_ALARM);

ringtone.stop(); //this will stop ringing