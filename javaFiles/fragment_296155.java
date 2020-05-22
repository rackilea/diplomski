public static String fix(String line) {
    if (line == null) {
        return null;
    }
    return line.replaceAll("(?i)\\b(can)(t)\\b", "$1'$2");
}