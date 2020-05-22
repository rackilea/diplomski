String re = "^\\s*(\\S+)\\s+(\\S+)\\s+(\\S+)\\s+(\\S+)\\s+(\\S+)\\s+(\\S+)\\s+(\\S+)\s+(\\S+)\\s+(\\S+)\\s*$";
Pattern p = Pattern.compile(re, Pattern.MULTILINE);
Matcher m = p.matcher(yourInputString);

while (m.find())
{
   // do stuff with m.group(1) through m.group(9)
}