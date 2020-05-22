String startDate = "28/11/19";
String endDate = "07/12/19";

SimpleDateFormat formatter5 = new SimpleDateFormat("dd/MM/yyyy");
Date date1 = formatter5.parse(startDate);
Date date2 = formatter5.parse(endDate);
System.out.println(date1);
System.out.println(date2);

formatter5 = new SimpleDateFormat("dd/MM/yy");
date1 = formatter5.parse(startDate);
date2 = formatter5.parse(endDate);
System.out.println(date1);
System.out.println(date2);
System.out.println(new Date());