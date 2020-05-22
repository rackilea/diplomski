Matcher matcher = pattern.matcher(userInput);
if (matcher.matches()){
    // this gives you the limits
    matcher.start();
    matcher.end();

    // this is the matched bit
    String matchedString = matcher.group();
    // now you've got to follow your %some %some $ pattern to separate the parts of the matchedString. You have to parse your pattern into parts and for each of those part find the part in matchedString that matches
}