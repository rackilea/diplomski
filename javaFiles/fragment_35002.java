import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class SoundService extends Service {

MediaPlayer mPlayer;

    @Override
    public void onCreate() {
        mPlayer = MediaPlayer.create(this, R.raw.music); 
        mPlayer.setLooping(true); 
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mPlayer.start();
        return Service.START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        mPlayer.stop();
        mPlayer.release();
        super.onDestroy();
    }

}