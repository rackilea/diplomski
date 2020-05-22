try {
   Date date = null;
   date = df.parse("2011-01-24 02:45:00");
   SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
   String shortTimeStr = sdf.format(date);
   System.out.println(shortTimeStr);
} catch (ParseException e) {
   // To change body of catch statement use File | Settings | File Templates.
   e.printStackTrace(); 
}