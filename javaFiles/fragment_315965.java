SimpleDateFormat month_date = new SimpleDateFormat("MMM yyyy", Locale.ENGLISH);
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

String actualDate = "2016-03-20";

Date date = sdf.parse(actualDate);

String month_name = month_date.format(date);
System.out.println("Month :" + month_name);  //Mar 2016