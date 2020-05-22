public class JulianDay {

    private static final int YEAR = 0;
    private static final int MONTH = 1;
    private static final int DAY = 2;
    private static final int HOURS = 3;
    private static final int MINUTES = 4;
    private static final int SECONDS = 5;
    private static final int MILLIS = 6;

    :
    :

    // Converts a timestamp presented as an array of integers in the following
    // order (from index 0 to 6): year,month,day,hours,minutes,seconds,millis
    // month (1-12), day (1-28 or 29), hours (0-23), min/sec (0-59) to a
    // Julian Day Number.
    // For clarity and simplicity, the input values are assumed to be well-formed;
    // error checking is not implemented in the snippet.

    public static double toJD(int[] ymd_hms) {

        int y = ymd_hms[YEAR];
        int m = ymd_hms[MONTH];
        double d = (double) ymd_hms[DAY];

        d = d + ((ymd_hms[HOURS] / 24.0) +
                 (ymd_hms[MINUTES] / 1440.0) +
                 (ymd_hms[SECONDS] / 86400.0) +
                 (ymd_hms[MILLIS] / 86400000.0));

        if (m == 1 || m == 2) {
            y--;
            m = m + 12;
        }

        double a = Math.floor(y / 100);
        double b = 2 - a + Math.floor(a / 4);

        return (Math.floor(365.25 * (y + 4716.0)) +
               Math.floor(30.6001 * (m + 1)) +
               d + b - 1524.5);
    }
}