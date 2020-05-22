String str = "[111111,111111,111111,111111,111111,111111,111111]"
//remove the brackets
//as backslash mentioned, str.substring is a better approach than using str.replaceAll with regex
str = str.substring(1, str.length()-1);
//split the string into an array
String[] strArray = str.split(",");