private static Optional<String> extractReference(String str) {
    Pattern pat = Pattern.compile("/(?<reference>[^/]+)(?=/ref)");
    return extractNamedGroup(str, pat, "reference");
}

private static Optional<String> extractPrice(String html) {
    Pattern pat = Pattern.compile("data-as-price\\s*=\\s*[\"'](?<price>.+?)[\"']", Pattern.MULTILINE);
    return extractNamedGroup(html, pat, "price");
}