/** Returns a String guaranteed to have no NULL character. */
String escape(String source) {
    return source.replace("&", "&amp;").replace("\u0000", "&null;");
}

/** Reverses the above escaping and returns the result. */
String unescape(String escaped) {
    return source.replace("&null;", "\u0000").replace("&amp;", "&");
}