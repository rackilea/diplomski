private final ThreadLocal<DateFormat> threadLocal =
        new ThreadLocal<DateFormat>() {
    @Override
    protected DateFormat initialValue() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");
    }
};
...
// get one that is per-thread
DateFormat dateFormat = threadLocal.get();