public static Date addDay(Date date){
   //TODO you may want to check for a null date and handle it.
   Calendar cal = Calendar.getInstance();
   cal.setTime (date);
   cal.add (Calendar.DATE, 1);
   return cal.getTime();
}