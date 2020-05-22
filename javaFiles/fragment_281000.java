public static Map<String, Integer> countWords(String input) {
    Map<String, Integer> map = new HashMap<String, Integer>();
    Matcher matcher = Pattern.compile("\\b\\w+\\b").matcher(input);
    while (matcher.find())
        map.put(matcher.group(), map.containsKey(matcher.group()) ? map.get(matcher.group()) + 1 : 1);
    return map;
}