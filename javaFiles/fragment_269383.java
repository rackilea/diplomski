import android.util.Log;

public class Logger {

    private static boolean AllowLogging = true;

    public void disableAndroidLogging() {
        AllowLogging = false;
    }

    public static int d(String label, String message) {
        if (AllowLogging) {
            return Log.d(label, message);
        }
        return 0;
    }
}