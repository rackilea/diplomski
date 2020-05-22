@Override
public void onChange(boolean selfChange) {
    super.onChange(selfChange);

    AudioManager audio = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
    int currentVolume = audio.getStreamVolume(AudioManager.STREAM_MUSIC);

    int delta=previousVolume-currentVolume;

    if(delta>0)
    {
        Logger.d("Decreased");
        previousVolume=currentVolume;
    }
    else if(delta<0)
    {
        Logger.d("Increased");
        previousVolume=currentVolume;
    }
}