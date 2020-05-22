String str = "jsLib//connect.facebook.net/en_US/fbevents.js , jsLib//connect.facebook.net/en_US/fbevents2.js;";
String patternStr = "[^/]*\\.js";
Pattern pattern = Pattern.compile(patternStr);
Matcher matcher = pattern.matcher(str);
while (matcher.find()) {
    System.out.println("jsLib:" + matcher.group());
}