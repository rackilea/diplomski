public class CrashReportingService {
    public static void initialise(Context context) {
        Fabric.with(context, new Crashlytics());
    }

    public static void logException(Throwable throwable) {
        Crashlytics.getInstance().core.logException(throwable);
    }
}