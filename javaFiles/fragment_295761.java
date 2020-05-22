public static long getTimeInMilliseconds(String unknownString) throws ParseException {

   DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
   String dateString = dateFormat.format(Calendar.getInstance().getTime());

   DateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
   return timeFormat.parse(dateString + " " + unknownString).getTime();
}