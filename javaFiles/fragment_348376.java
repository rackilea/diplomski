private static final Pattern classAttributePattern
        = Pattern.compile("\\bclass=\"([^\"]+)\"");
public static String disableTag(String tag) {
    Matcher matcher = classAttributePattern.matcher(tag);
    if (!matcher.find()) {
        throw new IllegalArgumentException("Doesn't match: " + tag);
    }
    int start = matcher.start();
    int end = matcher.end();
    String classValue = matcher.group(1);
    if (classValue.endsWith(" disable")) {
        return tag; // already disabled
    } else {
        // assume that if the class doesn't end with " disable",
        // then the disabled attribute is not present as well
        return tag.substring(0, start)
                + "class=\"" + classValue
                + " disable\" disabled=\"disabled\""
                + tag.substring(end);
    }
}