static List<String> uniqueString(List<String> lines) {
    List<String> uniques = new ArrayList<>();
    if (lines.size() == 0) return uniques;
    String prefix = lines.get(0);
    String suffix = lines.get(0);
    for (String s : lines) {
        while (!s.startsWith(prefix))
            prefix = prefix.substring(0, prefix.length() - 1);
        while (!s.endsWith(suffix))
            suffix = suffix.substring(1);
    }
    if (prefix.length() == 0 && suffix.length() == 0)
        uniques.add("");
    else
        for (String s : lines)
            uniques.add(s.substring(prefix.length(), s.length() - suffix.length()));
    return uniques;
}

@Test
public void testUniqueSubstrig() {
    System.out.println(uniqueString(Arrays.asList(
        "Katie walked to the beach in her fresh new kicks",
        "Katie walked to the arcade in her fresh new kicks",
        "Katie walked to the gazebo in her fresh new kicks"
    ))); // -> [beach, arcade, gazebo]
    System.out.println(uniqueString(Arrays.asList(
        "Eric walked home with nothing",
        "Brad jogged home with nothing",
        "Brad jogged home with seven bucks"
    ))); // -> []
    System.out.println(uniqueString(Arrays.asList(
        "Jill had fun",
        "Jill had salad for lunch",
        "Jill had twins!" 
    ))); // -> [fun, salad for lunch, twins!]
    System.out.println(uniqueString(Arrays.asList(
        "Bread",
        "Butter",
        "Bill Nye"
    ))); // -> [read, utter, ill Nye]
}