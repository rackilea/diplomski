public List<Character> asList(final char[] string) {
    return new AbstractList<Character>() {
       public int size() { return string.length; }
       public Character get(int index) { return string[index]; }
       public Character set(int index, Character newVal) {
          char old = string[index];
          string[index] = newVal;
          return old;
       }
    };
}