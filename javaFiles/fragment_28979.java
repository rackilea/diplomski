boolean containsWord(String s, String w) {
    List<Character> list = new LinkedList<Character>();
    for (char c : s.toCharArray()) {
        list.add(c);
    }
    for (Character c : w.toCharArray()) {
        if (!list.remove(c)) {
            return false;
        }
    }
    return true;
}