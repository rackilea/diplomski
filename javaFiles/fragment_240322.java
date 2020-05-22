Matcher matcher = Pattern.compile("\"(.*?)\".*?\"(.*?)\".*?\"(.*?)\".*?\"(.*?)\".*?").matcher(input);
if (matcher.find()) {
    System.out.println(matcher.group(1));
    System.out.println(matcher.group(2));
    System.out.println(matcher.group(3));
    System.out.println(matcher.group(4));
}