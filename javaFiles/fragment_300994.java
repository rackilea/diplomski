String fmt = "yyyy-MM-dd";
String dt = "2014-01-01";
java.text.DateFormat df = new java.text.SimpleDateFormat(fmt);
java.util.Calendar cal = java.util.Calendar.getInstance();
try {
    cal.setTime(df.parse(dt));
    cal.add(java.util.Calendar.DAY_OF_MONTH, -1);
    System.out.println(cal.getTime());
} catch (Exception e) {
}