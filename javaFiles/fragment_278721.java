boolean flag = false;
for (CoreMap sentence : sentences) {
    List<MatchedExpression> matched = extractor.extractExpressions(sentence);
    //System.out.println("Probable Header is : " + matched);
    Set<String> uniqueMatchedKeyWordSet = DocumentParserUtil.removeDuplicate(matched);
    System.out.println("Matched: " + uniqueMatchedKeyWordSet + " and Size of MatchedSet: " + uniqueMatchedKeyWordSet.size());

    // checked if the more than half the no. of word in header(string) is matched
    if ((matched.size() >= uniqueMatchedKeyWordSet.size()) && !matched.isEmpty() && matched.size() >= Math.floorDiv(string.split("\\s").length, 2)) {
        flag = true;
    } else {
        flag = false;
    }

}