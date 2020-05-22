public class Foo {
    private static volatile String FORMAT = "yyyyMMdd HHmm";

    // SimpleDateFormat is not thread-safe, so give one to each thread
    private static final ThreadLocal<SimpleDateFormat> formatter = 
        new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat(FORMAT);
        }
    };

    public static void setFormat(String format) {
        FORMAT = format;
    }
    ...
}