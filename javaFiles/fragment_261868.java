public static String replaceMiddle(String input, char divider) {    
    String result = input;

    Matcher matcher = Pattern.compile(":(\\w+):").matcher(input);

    if(matcher.find()){         
        String mid = matcher.group(1).replace( "a", "X");

        result = matcher.replaceAll(":" + mid + ":");
    }

    return result;
}