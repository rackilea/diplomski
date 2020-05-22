List<String> matchList = new ArrayList<String>();
Pattern regex = Pattern.compile(
    "\\{           # Match an opening brace.                              \n" +
    "(?:           # Match either...                                      \n" +
    " \"           #  a quoted string,                                    \n" +
    " (?:          #  which may contain either...                         \n" +
    "  \\\\.       #   escaped characters                                 \n" +
    " |            #  or                                                  \n" +
    "  [^\"\\\\]   #   any other characters except quotes and backslashes \n" +
    " )*           #  any number of times,                                \n" +
    " \"           #  and ends with a quote.                              \n" +
    "|             # Or match...                                          \n" +
    " [^\"{}]*     #  any number of characters besides quotes and braces. \n" +
    ")*            # Repeat as needed.                                    \n" +
    "\\}           # Then match a closing brace.", 
    Pattern.COMMENTS);
Matcher regexMatcher = regex.matcher(subjectString);
while (regexMatcher.find()) {
    matchList.add(regexMatcher.group());
}