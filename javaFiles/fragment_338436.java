import android.media.SoundPool;
//...

//inside your class:
//define: mContext = <your context>
private static SoundPool mSoundPool;
private static AudioManager mAudioManager;

//inside your method:
mSoundPool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
mAudioManager = (AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE);

int sound1 = mSoundPool.load(mContext, R.raw.sound1, 1); //<context, soundId, priority>
int sound2 = mSoundPool.load(mContext, R.raw.sound2, 1); //<context, soundId, priority>
int sound3 = mSoundPool.load(mContext, R.raw.sound3, 1); //<context, soundId, priority>

//play a sound:
mSoundPool.play(sound1, 1f, 1f, 1, 0, 1f);//soundId (from load()), volLeft, volRight, priority, loop(boolean), playbackRate


//register a callback for onLoad...:
mSoundPool1.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
    @Override
    public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
        //call .play() for the next sound
    }
});


//if you want to explicitly stop the sound:
mSoundPool.stop(sound1);