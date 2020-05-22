public static String getFormattedDate(int hour, int minute) {
    Calendar cale = Calendar.getInstance();
    cale.set(Calendar.HOUR_OF_DAY, hour);
    cale.set(Calendar.MINUTE, minute);
    SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
    return dateFormat.format(cale.getTime());
}