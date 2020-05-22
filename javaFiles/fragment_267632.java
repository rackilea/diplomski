Pattern p = Pattern.compile("#(\\w+)#");
String input = "#aaa# #bbb# #ccc#   #ddd#";
Matcher m = p.matcher(input);

List<String> parts = new ArrayList<String>();
while (m.find())
{
    parts.add(m.group(1));
}

// parts is [aaa, bbb, ccc, ddd]