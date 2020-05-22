String input = "\"  \"he\"\"\"\"! \"l0\" ! \"wor!\"d1\"";
Pattern p = Pattern.compile("(\".*\")\\s*!\\s*(\".*\")");
Matcher m = p.matcher(input);
if(m.matches())
{
  String s1 = m.group(1); //"  "he""""! "l0"
  String s2 = m.group(2); //"wor!"d1"
}