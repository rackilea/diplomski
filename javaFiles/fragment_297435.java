String str = "\"ValueFilter(\"val1\") AND ColumnFilter(\"val2\") AND ValueFilter(\"val3\")\"";
String regex = "(Value|Column)Filter\\((.*?)\\)";
Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher(str);

while (matcher.find()) {
    System.out.println(matcher.group());
}