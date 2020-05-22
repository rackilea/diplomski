Calendar cal = Calendar.getInstance();
int week = cal.get(Calendar.WEEK_OF_MONTH);
int day = cal.get(Calendar.DAY_OF_WEEK);
System.out.println(day);
Date mondayDate = null;
if (day > 2) {
  int monday = day - 2;
  cal.add(Calendar.DATE, -monday);
  mondayDate = cal.getTime();
} else {

  // cal.add(Calendar.DATE,);
  mondayDate = cal.getTime();
}

int sunday = 7 - day + 1;
cal.add(Calendar.DATE, +sunday);
Date sundaydate = cal.getTime();
System.out.println(mondayDate);
System.out.println(sundaydate);
}