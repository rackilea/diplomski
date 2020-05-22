import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;

public class DigitalClock extends Activity {
    private Runnable updateTimeTask;
    private Handler handler;

    public static final int TIME_UPDATE_INTERVAL_MSEC = 1000;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (updateTimeTask == null) {
            updateTimeTask = new Runnable() {
                @Override
                public void run() {
                    // if (!DigitalClock.this.isActive()) return;

                    timeAndDate();
                    handler.postDelayed(this, TIME_UPDATE_INTERVAL_MSEC);
                }
            };
        }
        if (handler == null) {
            handler = new Handler();
        }
        handler.removeCallbacks(updateTimeTask);
        handler.postDelayed(updateTimeTask, TIME_UPDATE_INTERVAL_MSEC);
    }

    public void timeAndDate() {
        Calendar c = Calendar.getInstance();

        SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss");
        SimpleDateFormat date = new SimpleDateFormat("MMMM dd yyyy");
        SimpleDateFormat day = new SimpleDateFormat("EEEE");
        SimpleDateFormat am_pm = new SimpleDateFormat("aa");
        String sTime = time.format(c.getTime());
        String sDate = date.format(c.getTime());
        String sDay = day.format(c.getTime());
        String sAm_Pm = am_pm.format(c.getTime());

        // formattedDate have current date/time
        Toast.makeText(this, sDate + " | " + sTime, Toast.LENGTH_SHORT).show();

        // Now we display value in TextView
        TextView txtTime = (TextView) findViewById(R.id.txtHour);
        TextView txtDay = (TextView) findViewById(R.id.txtDay);
        TextView txtDate = (TextView) findViewById(R.id.txtDate);
        TextView txtAm_Pm = (TextView) findViewById(R.id.txtAm_Pm);

        txtTime.setText(sTime);
        txtDate.setText(sDate);
        txtDay.setText(sDay);
        txtAm_Pm.setText(sAm_Pm);
    }
}