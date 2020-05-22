final MediaPlayer player = new MediaPlayer();
AssetFileDescriptor afd = 
   this.getResources().openRawResourceFd(R.raw.hangout_ringtone);
player.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), 
afd.getLength());
afd.close();
player.setAudioStreamType(AudioManager.STREAM_ALARM);
player.prepare();
player.start();
new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mMediaPlayer.stop();
            }
        }, 1000);//millisec.