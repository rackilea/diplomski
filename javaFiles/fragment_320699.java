Pattern p0 = Pattern.compile("(?m)^truck(?:(?:\r\n|[\r\n]).+$)*");
Matcher m = p0.matcher(data);
while (m.find())
{
  String fullMatch = m.group();
  int n = 0;
  for (String s : fullMatch.split("\r\n|[\r\n]"))
  {
    System.out.printf("line %d: %s%n", n++, s);
  }
}