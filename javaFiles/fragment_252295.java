MediaSession ms = new MediaSession(getApplicationContext(), getPackageName());
    ms.setActive(true);

    ms.setCallback(new MediaSession.Callback() {
        @Override
        public boolean onMediaButtonEvent(Intent mediaButtonIntent) {
            Log.e("hmhm", "hmhm media button");
            return super.onMediaButtonEvent(mediaButtonIntent);
        }
    });

    // you can button by receiver after terminating your app
    ms.setMediaButtonReceiver(mbr); 

    // play dummy audio
    AudioTrack at = new AudioTrack(AudioManager.STREAM_MUSIC, 48000, AudioFormat.CHANNEL_OUT_STEREO, AudioFormat.ENCODING_PCM_16BIT,
            AudioTrack.getMinBufferSize(48000, AudioFormat.CHANNEL_OUT_STEREO, AudioFormat.ENCODING_PCM_16BIT), AudioTrack.MODE_STREAM);
    at.play();

    // a little sleep 
    at.stop();
    at.release();