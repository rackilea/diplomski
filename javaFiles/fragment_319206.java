private Runnable UpdateSongTime = new Runnable() {
  @Override
  public void run() {
    if(currentTrack == 0){
      trueSeek = mediaPlayers.get(currentTrack).getCurrentPosition();
      startTime = trueSeek;
    }
    if(currentTrack > 0){
      int tempSeek = 0;
      for(int i = 0; i < currentTrack; i++){
        tempSeek += mediaPlayers.get(i).getCurrentPosition();
      }
      trueSeek = mediaPlayers.get(currentTrack).getCurrentPosition() + tempSeek;
      startTime = trueSeek;
    }
    seekBar.setMax(songEndTime);
    int currentSongEndTime = songEndTime - trueSeek;
    startTimeText.setText(convertSeekLength(startTime));
    String endTime = "-" + convertSeekLength(currentSongEndTime);
    songDisplay.setText(songArrayList.get(currentTrack).getTitle());
    endTimeText.setText(endTime);
    seekBar.setProgress(startTime);
    handler.postDelayed(this, 100);
  }
};