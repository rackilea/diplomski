String line = "add, $temp4, $temp40, 42";
String to = "register1";
String from = "$temp4";
String outString;

from = "(?<!\\w)" + Pattern.quote(from) + "(?!\\w)";

outString = line.replaceAll(from, to);
System.out.println(outString);
// => add, register1, $temp40, 42