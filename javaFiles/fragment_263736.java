import android.content.Context;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private LocationComponentCompassEngine compassEngine;
    private float previousCompassBearing = -1f;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView = findViewById(R.id.textView);

        CompassListener compassListener = new CompassListener() {

            @Override
            public void onCompassChanged(float targetCompassBearing) {
                if (previousCompassBearing < 0) {
                    previousCompassBearing = targetCompassBearing;
                }
                float normalizedBearing =
                        LocationComponentCompassEngine.shortestRotation(targetCompassBearing, previousCompassBearing);
                previousCompassBearing = targetCompassBearing;

                String status = "NO_CONTACT";
                switch (compassEngine.getLastAccuracySensorStatus()) {
                    case SensorManager.SENSOR_STATUS_NO_CONTACT:
                        status = "NO_CONTACT";
                        break;
                    case SensorManager.SENSOR_STATUS_UNRELIABLE:
                        status = "UNRELIABLE";
                        break;
                    case SensorManager.SENSOR_STATUS_ACCURACY_LOW:
                        status = "ACCURACY_LOW";
                        break;
                    case SensorManager.SENSOR_STATUS_ACCURACY_MEDIUM:
                        status = "ACCURACY_MEDIUM";
                        break;
                    case SensorManager.SENSOR_STATUS_ACCURACY_HIGH:
                        status = "ACCURACY_HIGH";
                        break;
                }

                textView.setText(String.format(Locale.getDefault(),
                        "CompassBearing: %f\nAccuracySensorStatus: %s", normalizedBearing, status));
            }

            @Override
            public void onCompassAccuracyChange(int compassStatus) {
            }

        };

        WindowManager windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        compassEngine = new LocationComponentCompassEngine(windowManager, sensorManager);
        compassEngine.addCompassListener(compassListener);

        compassEngine.onStart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compassEngine.onStop();
    }

}