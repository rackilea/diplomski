final Pattern pattern = Pattern.compile("[*]{3}\\d+[*]{3}");
final Matcher matcher = pattern.matcher("inputfile");
while (matcher.find())
{
  System.out.println(matcher.group());
}