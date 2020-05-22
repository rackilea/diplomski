public class MyService extends Service {
    public static final String ACTION_UPDATE = "MyServiceACTION_UPDATE";
    ...

    private void updateEmitterMethod() {
        LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent(ACTION_UPDATE));
    }
}