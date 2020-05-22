public static String getMonthName(int month){
    Locale locale = Locale.getDefault();
    SimpleDateFormat sdf = new SimpleDateFormat("MMMM",locale);
    Date date = new Date();
    date.setDate(1);
    date.setMonth(month);
    date.setYear(2012);
    return sdf.format(date);
}