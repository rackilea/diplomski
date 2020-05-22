String str = "\"NAME\":\"__NAME\"";
String regex = "(__(.*?))[\"\\[\\]\\(\\),]";
Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher(str);

while (matcher.find()) {
    System.out.println(matcher.group(1));
}