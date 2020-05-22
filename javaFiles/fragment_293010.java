public static String convertMillisToHMmSs(long millis) {
    long seconds = millis / 1000
    long s = seconds % 60;
    long m = (seconds / 60) % 60;
    long h = (seconds / (60 * 60));
    return String.format("%d:%02d:%02d", h,m,s);
}