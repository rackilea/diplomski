public static String encodeToHTML(String str) {
    return str
        .replace("'",  "&apos;")
        .replace("\"", "&quot;")
        .replace("<",  "&lt;")
        .replace(">",  "&gt;")
        .replace("&",  "&amp;");
}