List<String> delimList = new ArrayList<String>();
List<String> sectionList = new ArrayList<String>();
Pattern regex = Pattern.compile(
    "(<:==[\\]}]:>)     # Match a delimiter, capture it in group 1.\n" +
    "(                  # Match and capture in group 2:\n" +
    " (?:               # the following group which matches...\n" +
    "  (?!<:==[\\]}]:>) # (unless we're at the start of another delimiter)\n" +
    "  .                # any character\n" +
    " )*                # any number of times.\n" +
    ")                  # End of group 2", 
    Pattern.COMMENTS | Pattern.DOTALL);
Matcher regexMatcher = regex.matcher(subjectString);
while (regexMatcher.find()) {
    delimList.add(regexMatcher.group(1));
    sectionList.add(regexMatcher.group(2));
}