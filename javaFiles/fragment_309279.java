public Pattern createPatternFromSearch(String query) {
    StringBuilder sb = new StringBuilder();
    for (String part : query.split("\\*")) {
        if (part.length() > 0) {
            sb.append(Pattern.quote(part));
        }
        sb.append(".*");
    }
    return Pattern.compile(sb.toString());
}

// ...

// then you can use it like....
Matcher matcher = createPatternFromQuery("*DEF*mno*rst").matcher(str);
if (matcher.matches()) {
   // process the matching result
}