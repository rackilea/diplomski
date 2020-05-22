import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.analog.AnalogueView.OnMoveListener;



public class MainActivity extends Activity {
    AnalogueView analogue;
    TextView showMoveEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showMoveEvent = (TextView) findViewById(R.id.showMoveEvent);
        analogue = (AnalogueView) findViewById(R.id.analogueView1);
        analogue.setOnMoveListener(new OnMoveListener() {

            @Override
            public void onMaxMoveInDirection(double polarAngle) {
                showMoveEvent.setText("max move in "+polarAngle+" direction");
            }

            @Override
            public void onHalfMoveInDirection(double polarAngle) {
                showMoveEvent.setText("half move in "+polarAngle+" direction");

            }
        });
    }



}