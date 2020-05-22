private static String getRecursive(String source, int level) {
    if (level >= regexs.length) {
        return source;
    }
    return getRecursive(source.replaceAll(regexs[level], ""), level + 1);
}