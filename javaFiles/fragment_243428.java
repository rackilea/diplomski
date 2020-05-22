String value = "text1 <text2> text3 <text4>";
Pattern pattern = Pattern.compile("<([^>]*)>");
Matcher matcher = pattern.matcher(value);
while (matcher.find()) {
    System.out.println(matcher.group(1));
}