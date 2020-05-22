String str = "he.l.l.o.txt";
int lastIndexOfDot = str.lastIndexOf('.');
String str1 = str.substring(0, lastIndexOfDot + 1);
String str2 = str.substring(lastIndexOfDot, str.length());
str = str1.replace(".", "") + str2;
System.out.println(str);