private static Optional<String> extractPrice(String html) {
    Pattern pat = Pattern.compile("data-as-price\\s*=\\s*[\"'](?<price>.+?)[\"']", Pattern.MULTILINE);
    Matcher m = pat.matcher(html);
    if(m.find()) {
        String price = m.group("price");
        return Optional.of(price);
    }
    return Optional.empty();
}