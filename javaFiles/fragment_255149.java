String str = "some string \"\"14.62647\"\" some string";
String regex = "\"\"(.*?)\"\"";
Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher(str);

while (matcher.find()) {                                                
    System.out.println(matcher.group(1));
}