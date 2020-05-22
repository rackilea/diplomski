Pattern pxPattern = Pattern.compile("[0-9]+(?:%|pt|em)");
Matcher pxMatcher = pxPattern.matcher("margin: 0pt, 6em, 5%, 2pt");
List<String> propertyValues = new ArrayList<String>();
while (pxMatcher.find()) {
    propertyValues.add(pxMatcher.group());
}