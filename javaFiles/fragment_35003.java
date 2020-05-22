import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        startService(new Intent(MainActivity.this, SoundService.class));

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onBackPressed() {
        stopService(new Intent(MainActivity.this, SoundService.class));
        super.onBackPressed();    
    }

    @Override
    protected void onPause() {
        // When the app is going to the background
        stopService(new Intent(MainActivity.this, SoundService.class)); 
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        // when system temporarily destroying activity 
        stopService(new Intent(MainActivity.this, SoundService.class));
        super.onDestroy();
    }

}