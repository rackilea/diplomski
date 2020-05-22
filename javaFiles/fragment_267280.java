Pattern p = Pattern.compile("([^?']|\\?.)+");
String[] inputs = {
    "Hello??'There",
    "Hello???'There",
    "Hello????'There",
    "Hello?????'There",
    "Hello?????There",
    "Hello??????There"
};
for (String s : inputs)
{
  System.out.printf("%n%s :%n", s);
  Matcher m = p.matcher(s);
  while (m.find())
  {
    System.out.printf("  %s%n", m.group());
  }
}