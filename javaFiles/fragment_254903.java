String input = "ajlfjalfd one jlafjldaj two jlkajfldja";

    final String REGEX_STR = "(?=^.*(one|two))\\D+$";
    Pattern regex = Pattern.compile(REGEX_STR);
    Matcher regexMatcher = regex.matcher(input);

    return regexMatcher.matches();