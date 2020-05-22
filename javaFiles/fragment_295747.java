public static final String MODE_STATION_CHANGE = "STATION_CHANGE";

public void changeStation(int stationIndex){
  radioStreamURL = MainActivity.radioStreamURL.get(stationIndex);
  stop();
  play();
}