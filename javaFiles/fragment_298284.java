mAudioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
mSoundPool = new SoundPool(size, AudioManager.STREAM_MUSIC, 0);
mSoundPoolMap = new HashMap<Integer, Integer>();
mSoundPoolMap.put(index, mSoundPool.load(context, R.raw.sound, 1));


mSoundPool.play(id, streamVolume, streamVolume, 1, loop, 1f);