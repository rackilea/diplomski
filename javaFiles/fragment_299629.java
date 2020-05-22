public class BaseActivity extends AppCompatActivity {

    public static Context applicationContext = null;
    public static Thread.UncaughtExceptionHandler defaultHandler = null;
    public static Thread.UncaughtExceptionHandler exceptionHandler = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(defaultHandler == null){
            defaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        }

        if(applicationContext == null){
            applicationContext = getApplicationContext();
        }

        if(exceptionHandler == null){
            exceptionHandler = new Thread.UncaughtExceptionHandler() {
                @Override
                public void uncaughtException(Thread paramThread, Throwable paramThrowable) {
                    Log.e("Uncaught Exception", paramThrowable.getMessage());
                    logError(paramThrowable);
                    defaultHandler.uncaughtException(paramThread, paramThrowable);

                }
            };

            Thread.setDefaultUncaughtExceptionHandler(exceptionHandler);
        }
    }

    private static void logError(final Throwable paramThrowable){
        try {
            ApplicationError error = new ApplicationError();

            String stackTrace = "";
            for (int i = 0; i < paramThrowable.getStackTrace().length; i++) {
                stackTrace += paramThrowable.getStackTrace()[i].toString() + "\n";
            }

            Log.e("Saving error...", "");

            Throwable tmp = paramThrowable;
            int j = 0;
            while ((tmp = tmp.getCause()) != null && j < 5) {
                j++;
                stackTrace += "Coused by:\n";
                for (int i = 0; i < tmp.getStackTrace().length; i++) {
                    stackTrace += tmp.getStackTrace()[i].toString() + "\n";
                }
            }

            String deviceInfo = "";
            deviceInfo += "OS version: " + System.getProperty("os.version") + "\n";
            deviceInfo += "API level: " + Build.VERSION.SDK_INT + "\n";
            deviceInfo += "Manufacturer: " + Build.MANUFACTURER + "\n";
            deviceInfo += "Device: " + Build.DEVICE + "\n";
            deviceInfo += "Model: " + Build.MODEL + "\n";
            deviceInfo += "Product: " + Build.PRODUCT + "\n";

            error.mDeviceInfo = deviceInfo;
            error.mErrorMessage = paramThrowable.getMessage();
            error.mStackTrace = stackTrace;

            error.save();

            Log.e("Saved error:", error.mErrorMessage + "\n" + error.mStackTrace);
        }catch(Exception e){

        }
    }

}