String log;
String pattern = "(\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}\\.\\d{3})";
Pattern regex = Pattern.compile(pattern + ".*?START", Pattern.DOTALL);
Matcher m = regex.matcher(log);
while (m.find()) {
    System.out.println(m.group(1));
}