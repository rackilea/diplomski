private static Boolean isMatch(String abc, Set<String> patterns) {
    for (String pattern : patterns) {
        if (abc.matches(pattern.replace("*", "(.*)"))) {
            return true;
        }
    }
    return false;
}