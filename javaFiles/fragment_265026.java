import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.NotificationCompat;

import java.util.concurrent.TimeUnit;

import in.ashish29agre.stackoverflow.R;

public class CountdownTimerService extends Service {
    public static final String TIME_INFO = "time_info";

    private CounterClass timer;

    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        timer = new CounterClass(90000, 1000);
        timer.start();
        Intent notificationIntent = new Intent(this, ServiceTimerActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
                notificationIntent, Intent.FLAG_ACTIVITY_NEW_TASK);

        Notification notification = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_launcher)
                .setContentText("Counter down service")
                .setContentIntent(pendingIntent).build();

        startForeground(101, notification);

        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        timer.cancel();
        super.onDestroy();
        Intent timerInfoIntent = new Intent(TIME_INFO);
        timerInfoIntent.putExtra("VALUE", "Stopped");
        LocalBroadcastManager.getInstance(CountdownTimerService.this).sendBroadcast(timerInfoIntent);
    }

    public class CounterClass extends CountDownTimer {

        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            long millis = millisUntilFinished;
            String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis),
                    TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                    TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
            System.out.println(hms);
            Intent timerInfoIntent = new Intent(TIME_INFO);
            timerInfoIntent.putExtra("VALUE", hms);
            LocalBroadcastManager.getInstance(CountdownTimerService.this).sendBroadcast(timerInfoIntent);
        }

        @Override
        public void onFinish() {
            Intent timerInfoIntent = new Intent(TIME_INFO);
            timerInfoIntent.putExtra("VALUE", "Completed");
            LocalBroadcastManager.getInstance(CountdownTimerService.this).sendBroadcast(timerInfoIntent);
        }
    }
}