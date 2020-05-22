public class NotificationReceiver extends BroadcastReceiver {
    public static final string ACTION1 = "com.yourpackage.action1";
    public static final string ACTION2 = "com.yourpackage.action2";

    private IWorker worker;

    public NotificationReceiver() {
    }

    public NotificationReceiver(IWorker worker) {
        this.worker = worker;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(ACTION1)) {
            worker.doThis();
        } else if (intent.getAction().equals(ACTION2)) {
            worker.doThat();
        }
    }
}