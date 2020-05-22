String s = "Hello a l l you guys";
String key = "all";
String pat = "(?i)\\b" + TextUtils.join("\\W*", key.split("")) + "\\b";
System.out.println("Pattern: " + pat);
Matcher m = Pattern.compile(pat).matcher(s);
if (m.find())
{
    System.out.println("Found: " + m.group());
}