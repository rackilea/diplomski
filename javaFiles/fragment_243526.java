String input = "Some String lang:c,cpp,java file:build.java";
String langExpression = "lang:([\\w,]*)";
String fileExpression = "file:([\w\.]*)";

Patter langPattern = Pattern.compile(langExpression);
Matcher langMatcher = langPattern.matcher(input);
if (langMatcher.matches()) {
  String languageList = langMatcher.group(1);
}

Patter filePattern = Pattern.compile(fileExpression );
Matcher fileMatcher = filePattern.matcher(input);
if (fileMatcher .matches()) { 
  String filename= fileMatcher.group(1);
}