mSoundPool.setOnLoadCompleteListener(new OnLoadCompleteListener()
 {
    @Override
    public void onLoadComplete(SoundPool soundPool, int sampleId,int status) {
mSoundPool.play(sampleId, LEFT_VOLUME, RIGHT_VOLUME, PRIORITY, NO_LOOP, NORMAL_PLAY_RATE);

 }
 });