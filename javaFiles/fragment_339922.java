String myRegexPattern = "\"ROUTE_UNIQUE_ID_REFERENCE[\"\\s:]+([^\",]+)";
    Pattern pattern = Pattern.compile(myRegexPattern);
    Matcher matcher = pattern.matcher(myString);

    while (matcher.find()) {
        System.out.println(matcher.group(1));
    }