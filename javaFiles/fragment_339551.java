String xmlString = "{codecitation class=\"brush: java; gutter: true;\" width=\"700px\"}efasf{codecitation class=\"brush: java; gutter: true;\" width=\"700px\"}";
Pattern pattern = Pattern.compile("(\\{codecitation)([0-9 a-z A-Z \":;=]{0,})(\\})");
Matcher matcher = pattern.matcher(xmlString);

while (matcher.find()) {
    System.out.println(matcher.group());
}