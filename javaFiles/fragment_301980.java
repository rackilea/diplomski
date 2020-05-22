Pattern pattern = Pattern.compile(".*?(\\d+(?:\\.\\d+)?).*?-.*?(\\d+(?:\\.\\d+)?).*?");
Matcher matcher = pattern.matcher("13.9 mp - 14.9 mp");
while (matcher.find()) {
    System.out.println(matcher.group(1));
    System.out.println(matcher.group(2));
}