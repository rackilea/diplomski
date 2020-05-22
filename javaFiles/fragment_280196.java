public void playResume(boolean isPlayingFirebase) { //See the argument
    if (isFirstTimePlayClick) {
        try {
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.setDataSource(myUri);
            mediaPlayer.prepare();
            mediaPlayer.start();
            isFirstTimePlayClick = false;
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    } else{
        if(mediaPlayer.isPlaying()){
            mediaPlayer.pause();
        }
        else{
            mediaPlayer.start();
        }
    }
}