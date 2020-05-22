DateTime dt1 = new DateTime(d1);
DateTime dt2 = new DateTime(d2);

System.out.print(Days.daysBetween(dt1, dt2).getDays() + " days, ");
System.out.print(Hours.hoursBetween(dt1, dt2).getHours() % 24 + " hours, ");
System.out.print(Minutes.minutesBetween(dt1, dt2).getMinutes() % 60 + " minutes, ");
System.out.print(Seconds.secondsBetween(dt1, dt2).getSeconds() % 60 + " seconds.");