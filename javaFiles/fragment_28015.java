String input = "a1b2c3";
Pattern pattern = Pattern.compile("(?<x>.\\d)");
Matcher matcher = pattern.matcher(input);
while(matcher.find())
{
     System.out.println(matcher.group("x"));
}