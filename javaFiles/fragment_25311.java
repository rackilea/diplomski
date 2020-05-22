private static Optional<String> extractNamedGroup(String str, Pattern pat, String reference) {
    Matcher m = pat.matcher(str);
    if (m.find()) {
        return Optional.of(m.group(reference));
    }
    return Optional.empty();
}