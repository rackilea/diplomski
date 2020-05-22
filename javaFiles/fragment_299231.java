public static int indexOfPattern(List<String> list, String regex) {
    Pattern pattern = Pattern.compile(regex);
    for (int i = 0; i < list.size(); i++) {
        String s = list.get(i);
        if (s != null && pattern.matcher(s).matches()) {
            return i;
        }
    }
    return -1;
}