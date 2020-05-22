String from_date = "2016-03-26 00:00:00";
String due_date = "2016-03-27 00:00:00";

SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
Date fromDate = format1.parse(from_date);
Date dueDate = format1.parse(due_date);

System.out.println(getDaysBetweenDates(fromDate, dueDate));//prints "1"