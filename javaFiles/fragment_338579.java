public int convertMonthToNumber(String month){
     Date date = new SimpleDateFormat("MMMM", Locale.ENGLISH).parse(month);
     Calendar cal = Calendar.getInstance();
     cal.setTime(date);
     return cal.get(Calendar.MONTH);
}