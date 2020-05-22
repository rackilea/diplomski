StringBuffer sb = new StringBuffer();
Formatter f = new Formatter(sb, Locale.getDefault());
f.format("| %-50s |%n", "FIRST LINE");
f.format("| %-50s |%n", "200 100");
f.format("| %-50s |%n", "1000 2000");
String finalResult = sb.toString();
System.out.println(finalResult);