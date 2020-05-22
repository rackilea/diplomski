DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
final LocalDate dt1 = dtf.parseLocalDate(dateString1);
final LocalDate dt2 = dtf.parseLocalDate(dateString2);

final boolean check = dt1.isAfter(dt2);
if(check)
    System.out.println(dt1 +" is after "+dt2);
else
    System.out.println(dt2 +" is after "+dt1);