import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;

import com.google.android.gms.gcm.GcmListenerService;

public class MyGcmListenerService extends GcmListenerService {

    private NotificationCompat.Builder notificationBuilder;
    private NotificationManager notificationManager;
    private Uri defaultSoundUri;

    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    public void onMessageReceived(String from, Bundle data) {

        String message = data.getString("message");

        if (from.startsWith("/topics/")) {
            String topic = from.replace("/topics/", "");
            try {
                if (new SharedPreferencesHelper(this).getGCMTopics().contains(topic)) {
                    sendNotification(message, 0);
                }
            } catch (NullPointerException ignored) {

            }
        } else {
            if (message != null) {
                switch (message) {
                    case "0":
                        startService(new Intent(this, BackgroundUpdateService.class)
                                .putExtra(Constants.UPDATE, Constants.WHOLE_UPDATE)
                                .putExtra(Constants.CLEAR_UPDATE, true));
                        break;
                    case "1":
                        startService(new Intent(this, BackgroundUpdateService.class)
                                .putExtra(Constants.UPDATE, Constants.BOOKING_UPDATE));
                        sendNotification(Constants.BOOKING_NOTIFY, Integer.parseInt(message));
                        break;
                    case "2":
                        startService(new Intent(this, BackgroundUpdateService.class)
                                .putExtra(Constants.UPDATE, Constants.PACKAGE_UPDATE));
                        break;
                    case "3":
                        startService(new Intent(this, BackgroundUpdateService.class)
                                .putExtra(Constants.UPDATE, Constants.LOCATION_UPDATE));
                        break;
                    case "4":
                        startService(new Intent(this, BackgroundUpdateService.class)
                                .putExtra(Constants.UPDATE, Constants.MEETING_UPDATE));
                        sendNotification(Constants.MEETING_NOTIFY, Integer.parseInt(message));
                        break;
                    case "5":
                        startService(new Intent(this, BackgroundUpdateService.class)
                                .putExtra(Constants.UPDATE, Constants.MANAGER_UPDATE));
                        break;
                    case "6":
                        startService(new Intent(this, BackgroundUpdateService.class)
                                .putExtra(Constants.UPDATE, Constants.USER_UPDATE));
                        break;
                    case "7":
                        startService(new Intent(this, BackgroundUpdateService.class)
                                .putExtra(Constants.UPDATE, Constants.WHOLE_UPDATE));
                        break;
                    default:
                        sendNotification(message, 0);
                        break;
                }
            }

        }
    }

    private void sendNotification(String message, int i) {
        Intent intent = new Intent(this, ActivityDrawer.class).putExtra(Constants.CLEAR_NOTIFICATION, true);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent,
                PendingIntent.FLAG_ONE_SHOT);

        defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        Context context = this;
        SharedPreferencesHelper sharedPreferencesHelper = new SharedPreferencesHelper(context);

        notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Book That!")
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentText(message)
                .setContentIntent(pendingIntent);
        int notificationNumber;
        if (i == 1) {
            notificationNumber = sharedPreferencesHelper.getBookingNotificationNumber();

            sharedPreferencesHelper.setBookingNotificationNumber(++notificationNumber);
        } else if (i == 4) {
            notificationNumber = sharedPreferencesHelper.getMeetingNotificationNumber();

            sharedPreferencesHelper.setMeetingNotificationNumber(++notificationNumber);
        } else {
            notificationNumber = sharedPreferencesHelper.getNotificationNumber();

            sharedPreferencesHelper.setNotificationNumber(++notificationNumber);
        }
        notificationBuilder.setNumber(notificationNumber - 1);
        notificationManager.notify(i, notificationBuilder.build());
    }
}