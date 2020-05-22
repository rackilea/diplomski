String jsonString = "{\"M\":{\"row\":[{\"col1\":\"c00\"},{\"col1\":\"c10\",\"col2\":\"c11\"},{\"col1\":\"c20\",\"col2\":\"c21\",\"col3\":\"c22\"}]}}";
Pattern p = Pattern.compile("(\"col\\d+\":)(\"[^\"]*\")");
Matcher m = p.matcher(jsonString);
while (m.find()) {
    System.out.println(m.group(2));
}