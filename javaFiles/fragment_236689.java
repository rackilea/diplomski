String str = "sjfhshdkfjhskdhfksdf[a]sfdsgfsdf[bc]";
List<String> allMatches = new ArrayList<>();
Matcher m = Pattern.compile("\\[[^\\]]*]").matcher(str);
while (m.find()) {
    allMatches.add(m.group());
}