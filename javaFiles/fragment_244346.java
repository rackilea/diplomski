private boolean containsExactDrugName(String testString, String drugName) {

    Matcher m = Pattern.compile("\\b(?:" + drugName + ")\\b", Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE).matcher(testString);

    return m.find();
}