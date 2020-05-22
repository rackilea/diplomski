import java.util.Date;

public class DateConverter {

    private static long TicksToMillisOffset = 621355968000000000L;
    private static long TicksPerMillisecond = 10000L;

    public static Long toTicks(Date date)
    {
        if (date == null) return null;

        int offset = date.getTimezoneOffset() * 60;
        long ms = date.getTime();

        return (ms + offset) * TicksPerMillisecond + TicksToMillisOffset;   
    }

    public static Date fromTicks(Long ticks)
    {
        return ticks == null 
            ? null
            : new Date((ticks - TicksToMillisOffset) / TicksPerMillisecond);
    }

    public static String toJSONString(Date date) {
        return date != null ? date.toGMTString() : null;
    }

    public static Date fromJSONString(String string) {

        // expected: "/Date(secondssinceepoch)/"
        if (string.matches("^/Date\\(\\d+\\)/$")) {
            String value = string.replaceAll("^/Date\\((\\d+)\\)/$", "$1");
            return new Date(Long.valueOf(value));
        }
        else {
            return new Date(Date.parse(string));
        }

    }

}