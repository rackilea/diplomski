@override
public void onResume(){
    super.onResume();
    // this mute the Sound
    AudioManager mgr = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
    mgr.setStreamMute(AudioManager.STREAM_SYSTEM, true);
}

@override
public void onPause(){
    super.onPause();
    AudioManager mgr = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
    mgr.setStreamMute(AudioManager.STREAM_SYSTEM, false);
}