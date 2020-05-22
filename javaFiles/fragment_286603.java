private static final ThreadLocal<SimpleDateFormat> formats =
    new ThreadLocal<SimpleDateFormat>() {
        @Override protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss", Locale.US);
        }
    };

public void setDate(String string) throws ParseException {
    return formats.get().parse(string);
}