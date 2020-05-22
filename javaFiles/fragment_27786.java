public static String convertDate(String dateInMilliseconds, String dateFormat) {
DateFormat df = new SimpleDateFormat(dateFormat);
Calendar c = Calendar.getInstance();
c.setTimeInMillis(Long.parseLong(dateInMilliseconds));
c.add(Calendar.HOUR_OF_DAY, 1); //Work-around to get your lost hour
return df.format(c.getTime());
}