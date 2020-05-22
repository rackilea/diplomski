Intent broadcastIntent = new Intent(mContext, NotificationReceiver.class);
 broadcastIntent.putExtra(Const.NOTIFICATION_ID,"1";
 PendingIntent cancleIntent = PendingIntent.getBroadcast(mContext,
            0, broadcastIntent, PendingIntent.FLAG_CANCEL_CURRENT);

public class NotificationReceiver extends BroadcastReceiver {
@Override
public void onReceive(Context context, Intent intent) {
    if (intent.hasExtra(Const.NOTIFICATION_ID)) {
        int notificationId = intent.getIntExtra(Const.NOTIFICATION_ID, 0);

       // do your logic like cancle notification
         NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            manager.cancel(notificationId);

    }


}
}