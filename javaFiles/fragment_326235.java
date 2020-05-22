String text = "elephant-rides are really fun!";
Pattern r = Pattern.compile("(?U)(\\w)(\\w{2,})(\\w)");
Matcher m = r.matcher(text);
String result = m.replaceAll(x -> x.group(1) + x.group(2).length() + x.group(3));
System.out.println( result );
// => e6t-r3s are r4y fun!