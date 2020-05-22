public static String slugify(String input) {
    return Normalizer.normalize(input, Normalizer.Form.NFD)
            .replaceAll("[^\\p{ASCII}]", "")
            .replaceAll("[^ \\w]", "").trim()
            .replaceAll("\\s+", "-").toLowerCase(Locale.ENGLISH);
}