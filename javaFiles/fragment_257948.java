Pattern pattern = Pattern.compile("\\{(.*?)\\}$");
Matcher matcher = pattern.matcher(s);
if (matcher.find())
{
    System.out.println(matcher.group(1));
}