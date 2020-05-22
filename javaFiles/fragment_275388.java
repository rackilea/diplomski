private static String getFormattedDate() {
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("EEEEEEEEE dd:MM:yyyy, HH:mm:ss");      

    return sdf.format(cal.getTime());

}

private static String getTimeZone() {
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("z");       

    return sdf.format(cal.getTime());

}