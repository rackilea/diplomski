// java    
String input = "Thu, 8 Dece 2016 09:54:00 GMT";
String p = "[^.*,\\s\\d+\\s+]+[\\s+]";
Pattern pattern = Pattern.compile(p);
Matcher m = pattern.matcher(input);
while (m.find()) {
    String month = m.group().substring(0, 3);
    input = input.replaceFirst(p, month + " ");
}
System.out.println(input); // Thu, 8 Dec 2016 09:54:00 GMT