private boolean containsExactDrugName(String testString, String drugName) {

    Matcher m = Pattern.compile("\\b(?:" + drugName + ")\\b", Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE).matcher(testString);
    List<String> results = new ArrayList<>();

    while (m.find()) {
        results.add(m.group());
    }

    return !results.isEmpty();
}