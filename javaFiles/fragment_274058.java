public List<Character> asList(final String string) {
    return new AbstractList<Character>() {
       public int size() { return string.length(); }
       public Character get(int index) { return string.charAt(index); }
    };
}