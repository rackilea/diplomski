String input = "The Signature refers to test id 69043 abcd. ";
input += "The Signature refers to test id 1001";
String pattern = "(?i)test\\s+id\\s+(\\d+)";
Pattern r = Pattern.compile(pattern);
Matcher m = r.matcher(input);

while (m.find()) {
   System.out.println("Found value: " + m.group(1) );
}