String str = "\"XFilter(\"val1\") AND YFilter(\"val2\") AND XFilter(\"val3\")\"";
String regex = "[XY]Filter\\((.*?)\\)";
Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher(str);

while (matcher.find()) {                                                
    System.out.println(matcher.group());
}