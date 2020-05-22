public static boolean containsSeparated(String condition, List<String> keywords) {
    for (String word : keywords) {
        Pattern p = Pattern.compile("\\S" + word + "|" + word + "\\S");
        Matcher matcher = p.matcher(condition);
        boolean foundNotSeparated = matcher.find();
        if (foundNotSeparated) {
            return false;
        }
    }
    return true;
}