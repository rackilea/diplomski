String stdate = "01/01/2014 09:30:30";
String endate = "09/11/2015 11:30:30";
SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
Date d1 = df.parse(stdate);
Date d2 = df.parse(endate);;

DateTime startTime = new DateTime(d1), endTime = new DateTime(d2);
Period p = new Period(startTime, endTime);
System.out.printf("%-8s %d %n","years:",p.getYears());
System.out.printf("%-8s %d %n","months:",p.getMonths());
System.out.printf("%-8s %d %n","weeks:",p.getWeeks());
System.out.printf("%-8s %d %n","days:",p.getDays());
System.out.printf("%-8s %d %n","hours:",p.getHours());
System.out.printf("%-8s %d %n","minutes:",p.getMinutes());
System.out.printf("%-8s %d %n","second:",p.getSeconds());