String oldstring = "2013-01-1";
System.out.println("oldstring = "+oldstring);
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
Date date = sdf.parse(oldstring);
System.out.println("datefield = "+date);
String outDateStr = sdf.format(date);
System.out.println("newstring = "+outDateStr);