Pattern pattern = Pattern.compile("resultCount\":\\s*(\\d+)");

Matcher matcher = pattern.matcher(str);

while (matcher.find()) {
    System.out.println(matcher.group(1));
}