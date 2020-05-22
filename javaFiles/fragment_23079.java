// your input text
String myText = "Date(123)";
// your Pattern initialization
Pattern p = Pattern.compile("Date\\(\\d+\\)");
// your matcher initialization
Matcher m = p.matcher(myText);
// printing the output of the match...
System.out.println(m.find());