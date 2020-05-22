Date now = new Date();
Calendar compareTo = Calendar.getInstance();
compareTo.add(Calendar.MONTH, -6);
compareTo.add(Calendar.DATE, -4);
if (compareTo.getTime().before(now)) {
   // after
} else {
   // before or equal 
}