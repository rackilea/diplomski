Pattern pattern = Pattern.compile("(?<=pp_).*(?=')");
String input = "['newPage', 'pp_vii', -1])";
Matcher m = pattern.matcher(input);
boolean stringMatches = m.matches(); // false
boolean isThereMatch = m.find(); // true
System.out.println(isThereMatch + " " + stringMatches);
System.out.println(m.group());