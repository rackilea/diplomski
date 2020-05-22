import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import in.ashish29agre.stackoverflow.R;

public class ServiceTimerActivity extends AppCompatActivity {

    TextView textViewTime;
    private TimerStatusReceiver receiver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_timer);
        textViewTime = (TextView) findViewById(R.id.status_tv);
        receiver = new TimerStatusReceiver();
    }


    @Override
    protected void onResume() {
        super.onResume();
        LocalBroadcastManager.getInstance(this).registerReceiver(receiver, new IntentFilter(CountdownTimerService.TIME_INFO));
    }

    @Override
    protected void onPause() {
        super.onPause();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(receiver);
    }

    public void startService(View view) {
        Intent intent = new Intent(this, CountdownTimerService.class);
        startService(intent);
    }

    public void stopService(View view) {
        Intent intent = new Intent(this, CountdownTimerService.class);
        stopService(intent);
    }


    private class TimerStatusReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getAction().equals(CountdownTimerService.TIME_INFO)) {
                if (intent.hasExtra("VALUE")) {
                    textViewTime.setText(intent.getStringExtra("VALUE"));
                }
            }
        }
    }
}