String str = "(?<name>john)/***(?<facet>aaa/bbb/ccc/?)/(?<not>aaa/bbb/?)***";
Matcher matcher = Pattern.compile("(?:/|^)(\\(\\?<.*?>.*?\\))(?=/|$)").matcher(str);

while (matcher.find()) {
    System.out.println(matcher.group(1));
}