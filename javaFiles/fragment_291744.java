public static List<String> splitIt(String source)
{
  Pattern p = Pattern.compile("(?:[^|\\\\]|\\\\.)+");
  Matcher m = p.matcher(source);
  List<String> result = new ArrayList<String>();
  while (m.find())
  {
    result.add(m.group().replaceAll("\\\\(.)", "$1"));
  }
  return result;
}

public static void main(String[] args) throws Exception
{
  String[] test = { "One|Two|Three", 
                    "One\\|Two\\|Three", 
                    "One\\\\|Two\\|Three", 
                    "One\\\\\\|Two" };
  for (String s :test)
  {
    System.out.printf("%n%s%n%s%n", s, splitIt(s));
  }
}