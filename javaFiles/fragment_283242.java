Date fromDate = ...;
Date toDate = ...;

System.out.println("From " + fromDate);
System.out.println("To " + toDate);

Calendar cal = Calendar.getInstance();
cal.setTime(fromDate);
while (cal.getTime().before(toDate)) {
    cal.add(Calendar.DATE, 1);
    System.out.println(cal.getTime());
}