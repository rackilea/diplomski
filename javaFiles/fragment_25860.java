String str = "2000-05-12T12:00"; 
SimpleDateFormat parserSDF = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
Date d = parserSDF.parse(str);

Calendar cal = Calendar.getInstance();
cal.setTime(d);

System.out.println(cal.get(Calendar.DAY_OF_MONTH));
System.out.println(cal.get(Calendar.MONTH)); // month in the Calendar class begins from 0
System.out.println(cal.get(Calendar.YEAR));
System.out.println(cal.get(Calendar.HOUR_OF_DAY));
System.out.println(cal.get(Calendar.MINUTE));
System.out.println(cal.get(Calendar.SECOND));