public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if (!isMainProcess()) {
            // Do not call thread unsafe logic. Just return
            return;
        }
        // Thread unsafe logic.
        ...
    }

    private boolean isMainProcess() {
        int pid = android.os.Process.myPid();
        ActivityManager manager = (ActivityManager) this.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo processInfo : manager.getRunningAppProcesses()) {
            String currentProcName = processInfo.processName;
            if (processInfo.pid == pid) {
                if (TextUtils.equals(currentProcName, BuildConfig.APPLICATION_ID)) {
                    return true;
                }
            }
        }
        return false;
    }
}