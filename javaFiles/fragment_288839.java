Pattern p = Pattern.compile("<span>([^<&]+)&nbsp;</span>");
Matcher m = p.matcher(text);
while (m.find())
{
  System.out.println(m.group(1));
}