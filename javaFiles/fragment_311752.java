String template = "[chicken]";
String pattern = "\\G(?<!\\[)(\\w+)(?!\\])";
Pattern p = Pattern.compile(pattern);
Matcher m = p.matcher(template);

while (m.find()) 
{
     System.out.println(m.group());
}