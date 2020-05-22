Pattern pattern = Pattern.compile("(?:Name:.*?)(?:Name: )([^\\n]+)", Pattern.DOTALL);
Matcher matcher = pattern.matcher(myString);
String secondName = "";
if (matcher.find())
    secondName = matcher.group(1);
System.out.println(secondName);