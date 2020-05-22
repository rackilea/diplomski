public void setLocalSong(String localsong) throws IOException {
    if(mediaPlayer != null){
        mediaPlayer.stop();            
        mediaPlayer.release();
        mediaPlayer=null;
    }
    mediaPlayer = new MediaPlayer();
    mediaPlayer.setDataSource(localsong);
    mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
    mediaPlayer.prepare();
    mediaPlayer.start();

}