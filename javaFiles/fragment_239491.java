Calendar cal = new GregorianCalendar();
cal.set(Calendar.DAY_OF_MONTH, 10);
// etc...

if (System.currentTimeMillis() < cal.getTimeInMillis()) {
  // do your stuff
}