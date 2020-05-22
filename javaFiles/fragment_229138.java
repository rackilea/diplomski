String s = "Football: Real Madrid 2-1 FC Barcelona";
String PATTERN_SPORT = "([a-zA-Z]+\\s?[0-9]?)";
String PATTERN_NAME = "(.*)";
String PATTERN_RESULT = "([0-9]*)-([0-9]*)";
Pattern PATTERN_SPORT_AND_HOME_TEAM_RESULT_AWAY_TEAM = Pattern.compile("^" + PATTERN_SPORT + ":\\s" + PATTERN_NAME + "\\s" + PATTERN_RESULT + "\\s?" + PATTERN_NAME + "$", Pattern.UNICODE_CHARACTER_CLASS);

Matcher matcher = PATTERN_SPORT_AND_HOME_TEAM_RESULT_AWAY_TEAM.matcher(s);
if (matcher.matches()){
    System.out.println(matcher.group(1)); 
    System.out.println(matcher.group(2)); 
    System.out.println(matcher.group(3)); 
    System.out.println(matcher.group(4)); 
    System.out.println(matcher.group(5)); 
}