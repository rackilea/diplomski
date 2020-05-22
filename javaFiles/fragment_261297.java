private static Boolean isMatch(String abc, Set<String> patterns) {
    for (String pattern : patterns) {
        Pattern r = Pattern.compile(pattern.replace("*", "(.*)"));
        if (r.matcher(abc).matches()) {
            return true;
        }
    }
    return false;
}