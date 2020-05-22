String str = "sjfhshdkfjhskdhfksdf[a]sfdsgfsdf[bc]";
List<String> allMatches = new ArrayList<>();
for (int i = str.indexOf('['), j; i != -1; i = str.indexOf('[', j + 1)) {
    j = str.indexOf(']', i + 1);
    // if `j` is -1, the brackets are unbalanced. Perhaps throw an Exception?
    allMatches.add(str.substring(i, j + 1));
}