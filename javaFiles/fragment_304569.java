public static void playBackMusic() {
        try {
            mediaPlayer.release();

            mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.setDataSource(currentSong.getPath());
            mediaPlayer.prepare();

            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    endOfTheSong();
                }
            });

            isPlaying = true;
            mediaPlayer.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }