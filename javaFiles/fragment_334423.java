Pattern h2Pattern = Pattern.compile("<h2.*?>");
Matcher h2Matcher = h2Pattern.matcher("");
for (String temp2 : myAnchorLinks) {
    h2Pattern.reset(replaceAllTags);
    replaceAllTags = h2Matcher.replaceAll("<h2 id="+temp2+">");
}