int count = 0;
for (String searchString : searchStrings) {
    Pattern pattern = Pattern.compile("\\b" + Pattern.quote(searchString) + "\\b");
    Matcher matcher = pattern.matcher(input);
    if (matcher.find()) {
        count++;
    }
}