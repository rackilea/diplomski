import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

private MediaPlayer mp;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    // final MediaPlayer mp = new MediaPlayer();
    mp = new MediaPlayer();
}

public void button1(View v) {
    // Button button1 = (Button)findViewById(R.id.button1);
    mp.release();
    mp = MediaPlayer.create(this, R.raw.muzika);
    mp.start();
}

public void button2(View v) {
    // Button button2 = (Button)findViewById(R.id.button2);
    mp.release();
    mp = MediaPlayer.create(this, R.raw.muzikb);
    mp.start();
}

@Override
public void onDestroy() {
    mp.release();
}

}