static Set<Character> usedCharactersIn(String s) {
    Set<Character> set = new HashSet<Character>();
    for (char ch : s.toLowerCase().toCharArray()) {
        set.add(ch);
    }
    return set;
}