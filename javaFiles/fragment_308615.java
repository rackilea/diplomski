String value1 = "15 000 km\n15,000 km\n15.000 km\n15 000 km";
String pattern1 = "(?U)\\d+[\\s.,]?\\d+";
Pattern ptrn = Pattern.compile(pattern1);
Matcher matcher = ptrn.matcher(value1);
while (matcher.find())
    System.out.println(matcher.group(0));