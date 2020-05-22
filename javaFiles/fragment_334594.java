String str = "1/1/2013 to 1/7/2013";
String startDate = str.substring(0,str.indexOf(" "));
String endDate = str.substring(str.lastIndexOf(" ")+1);¨
// The rest is the same:
String[] start = startDate.split("/");
System.out.println(start[0] + "-" + start[1] + "-" + start[2]);
String[] end = endDate.split("/");
System.out.println(end[0] + "-" + end[1] + "-" + end[2]);