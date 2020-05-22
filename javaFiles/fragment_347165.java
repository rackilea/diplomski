String target = "Oct 2000";
DateFormat df = new SimpleDateFormat("MMM yyyy", Locale.ENGLISH);
try{
  Date date = df.parse(target);
  Calendar calendar = Calendar.getInstance();
  Calendar targetCalendar = Calendar.getInstance();
  targetCalendar.setTime(date);
  System.out.println(targetCalendar.get(Calendar.MONTH) == calendar.get(Calendar.MONTH));
 } catch (ParseException e){
 }