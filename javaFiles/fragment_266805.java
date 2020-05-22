import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class GenerateBroadcastActivity extends Activity 
{
    Button bt ;

    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.generate_broadcast);

        bt = (Button) findViewById(R.id.bt1);
        bt.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                startService(new Intent(getApplicationContext(),MyNewService.class));
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(receiver, new IntentFilter("BROADCAST_UNIQUE_NAME"));
    }

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

             //take out data from intent
              int progressValue = intent.getIntExtra("progressValue",0);

             // just for instance , you can set the progress in your progress bar //defined globally in your app 
              progressBar.setProgress(progressValue);  

            Toast.makeText(context, "Broadcast coming with Progress value" + progressValue, Toast.LENGTH_LONG).show();          
        }
    };
}