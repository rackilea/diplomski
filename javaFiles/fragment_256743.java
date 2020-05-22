Calendar cal = Calendar.getInstance();
 cal.set(Calendar.WEEK_OF_YEAR, week);
 Date yourDate = cal.getTime();

 cal.setTime(yourDate);//Set specific Date of which start and end you want

 Date start,end;

 cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
 start = cal.getTime();//Date of Monday of current week

 cal.add(Calendar.DATE, 6);//Add 6 days to get Sunday of next week
 cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
 end = cal.getTime();//Date of Sunday of current week
 System.out.println(start +" - "+ end);