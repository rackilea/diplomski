@Override
    public void onCreate() {
    radioStreamURL.add(radioStreamURL);
    radioStreamURL.add(radioStreamURL2);
    radioStreamURL.add(radioStreamURL3);
    // etc
}
 public void prepare() {     
        /* Prepare Async Task - starts buffering */
        try {           
            mediaPlayer.setDataSource(radioStreamURL.get(radioStreamingIndex));
            mediaPlayer.prepareAsync();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

public void nextStation(){
  changeStation(radioStreamingIndex+1);
}

public void prevStation(){
  changeStation(radioStreamingIndex-1);
}

private void changeStation(int stationIndex){
  if(stationIndex > 0 && stationIndex < radioStreamURL.size()){
  radioStreamingIndex = stationIndex;
  stop();
  play();
  }
}