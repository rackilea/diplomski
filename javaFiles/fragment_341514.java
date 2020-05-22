private boolean _initialized;

public synchronized void loadLatestData() {
  if(!_initialized) {
      // load latest data ...
      _initilized = true;
  }
}