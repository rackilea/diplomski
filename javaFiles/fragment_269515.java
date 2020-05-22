public static void main(String[] args) {
    String english = "Your Last Login was 2013/10/04 13:06:45 ( 0 Days, 0 Hours, 0 Minutes )";
    String chinese = "您上次登录是 2013/10/04 13:06:45（ 0 天， 0 小时 0 分钟 ）";

    String datePattern = "\\d\\d\\d\\d/\\d\\d/\\d\\d"; 
    String timePattern = "\\d\\d:\\d\\d:\\d\\d";

    System.out.println(getMatch(english, datePattern));
    System.out.println(getMatch(english, timePattern));
    System.out.println(getMatch(english, "\\d Days"));
    System.out.println(getMatch(english, "\\d Hours"));
    System.out.println(getMatch(english, "\\d Minutes"));
    System.out.println();
    System.out.println(getMatch(chinese, datePattern));
    System.out.println(getMatch(chinese, timePattern));
    System.out.println(getMatch(chinese, "\\d 天"));
    System.out.println(getMatch(chinese, "\\d 小时"));
    System.out.println(getMatch(chinese, "\\d 分钟"));
}

private static String getMatch(String input, String regex) {
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(input);
    if (matcher.find()) {
        return matcher.group();
    } else {
        return "";
    }
}