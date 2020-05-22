private static int categorize(String input) {
    Matcher m = Pattern.compile("(?i)\\bAND(\\s+NOT)?\\b").matcher(input);
    boolean foundAndNot = false, foundAnd = false;
    while ((! foundAndNot || ! foundAnd) && m.find())
        if (m.start(1) != -1)
            foundAndNot = true;
        else
            foundAnd = true;
    return (foundAndNot ? (foundAnd ? 1 : 3)
                        : (foundAnd ? 2 : 0));
}