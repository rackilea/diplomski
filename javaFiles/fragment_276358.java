String rel = "\\{(.*?)\\}";   // Curly Braces 1
List<String> allMatches = new ArrayList<String>();
Pattern p = Pattern.compile(rel, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
Matcher m = p.matcher(DATA);

while (m.find()) {
    String foundOccurence = m.group(1);
    foundOccurence = foundOccurence.replaceAll("=([^\"\\n]+)", "=\"$1\"");
    foundOccurence = foundOccurence.replaceAll("\\s*([\\w]+)=(\".*\")\\n", "  \"$1\": $2,\n");
    allMatches.add("{\n" + foundOccurence.substring(0, foundOccurence.length() - 2) + "\n},\n");
}

StringBuilder builder = new StringBuilder();
for (String occurence : allMatches) {
    builder.append(occurence);
}
String result = builder.substring(0, builder.length() - 2);