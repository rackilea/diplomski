public class BackgroundSound extends Service {
private static final String TAG = null;
MediaPlayer player;

public IBinder onBind(Intent arg0) {

    return null;
}

@Override
public void onCreate() {
    super.onCreate();
    player = MediaPlayer.create(this, R.raw.audiofile);
    player.setLooping(true); // Set looping
    player.setVolume(100, 100);

}

public int onStartCommand(Intent intent, int flags, int startId) {
    player.start();
    return 1;
}

public void onStart(Intent intent, int startId) {
    // TO DO
}

public IBinder onUnBind(Intent arg0) {
    // TO DO Auto-generated method
    return null;
}

public void onStop() {

}

public void onPause() {

}

@Override
public void onDestroy() {
    player.stop();
    player.release();
}

@Override
public void onLowMemory() {

}
  }