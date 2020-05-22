public void onCompletion(MediaPlayer mediaPlayer) {
  for(int i = 0; i < currentTrack; i++) {
    trueSeek += mediaPlayers.get(i).getCurrentPosition();
  }
  currentTrack++;
  if(currentTrack >= mediaPlayers.size()){
    currentTrack = 0;
  }
  handler.post(UpdateSongTime);
  mediaPlayers.get(currentTrack).start();
}