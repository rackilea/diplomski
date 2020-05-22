public int lengthOfSubStringsMatchingRegex(String input, String regex)
    Pattern p = Pattern.compile(regex);
    Matcher m = p.matcher(input);

    int count = 0;
    while (m.find())
        count += m.group().length();

    return count;
}