String s = "nameClass(val1)(val2)(val3)";
Pattern p = Pattern.compile("^(\\w+) *(.*)$");
Matcher m = p.matcher(s);
String ps = "";
if (m.matches())
{
  ps = m.group(2);
  System.out.printf("Outside parantheses:<%s>\n", m.group(1));
}
Pattern p1 = Pattern.compile("\\(([^)]*)\\)");
Matcher m1 = p1.matcher(ps);
while (m1.find())
{
  System.out.printf("Inside parentheses:<%s>%n", m1.group(1));
}