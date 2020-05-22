String REGEX = "\\{[^}]*\\}";
String INPUT = "This is a test {replace_me}. And this is another {replace_me_too}.";
String REPLACE = "xxx";
Pattern p = Pattern.compile(REGEX);

Matcher m = p.matcher(INPUT); 
INPUT = m.replaceFirst(REPLACE);
System.out.println(INPUT);