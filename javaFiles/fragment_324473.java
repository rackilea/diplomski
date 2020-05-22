class Main {

    public static long dateToTimestamp(Date date) {
        Calendar cal = Calendar.getInstance(Locale.ENGLISH);
        cal.setTime(date);
        return cal.getTimeInMillis() / 1000L;
    }

    public static Date timeStampToDate(long timestamp) {
        Calendar cal = Calendar.getInstance(Locale.ENGLISH);
        cal.setTimeInMillis(timestamp * 1000L);
        return cal.getTime();
    }

    public static void main(String[] args) {
        long date = 1000;

        System.out.println("Time as Date: " + timeStampToDate(date));
        System.out.println("Time in timestamp: " + dateToTimestamp(timeStampToDate(date)));
    }

}