public class MyService extends Service {
    private PowerManager powerManager;
    private static PowerManager.WakeLock wakeLock;
    ...
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        ...
        powerManager = (PowerManager) getSystemService(POWER_SERVICE);
        wakeLock = powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "MyWakelockTag");
        wakeLock.acquire();
        ...
}