Date date = new Date();

System.out.println(TimeZone.getDefault());
System.out.println(date);

TimeZone.setDefault(TimeZone.getTimeZone("UTC"));

System.out.println(TimeZone.getDefault());
System.out.println(date);