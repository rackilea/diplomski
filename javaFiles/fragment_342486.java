String regex = "Key1=(.*),Key2=(.*)"; // etc.
Pattern p = Pattern.compile(regex);
Matcher m = p.matcher(targetString);
// Now you have to apply the regex:
if (m.find())
{
  String value1 = m.group(1);
  String value2 = m.group(2);
  // etc.
}