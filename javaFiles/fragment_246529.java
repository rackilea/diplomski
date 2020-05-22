Object obj = "[FIBER,CABLE]";

String str = (String) obj;
if (! str.startsWith("[") || ! str.endsWith("]"))
    throw new IllegalArgumentException("Bad data: " + str);
String[] strArray = str.substring(1, str.length() - 1).split(",", -1);

for (String s : strArray)
    System.out.println(s);