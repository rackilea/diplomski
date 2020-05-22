class StringSorter implements Comparator<String> {
    private final int pos;

    public StringSorter(int pos) {
        this.pos = pos;
    }

    public int compare(String s1, String s2) {
        if (s1.length() < s2.length()) {
            return -1;
        }
        if (s1.length() > s2.length()) {
            return 1;
        }
        if ( s1.length() <= pos ) {
            return s1.compareTo(s2);
        }
        return Character.compare(s1.charAt(pos),s2.charAt(pos));
    }
}

public void test() {
    String[] test2 = {"1:bbbbb", "2:aaa", "=:ccc", "1:qqqq", "1:eeee", "=:zzz", "1:vvv", "2:oooo", "=:eee", "1:fffff"};
    System.out.println("Before: " + Arrays.toString(test2));
    Arrays.sort(test2, new StringSorter (2));
    System.out.println("After:  " + Arrays.toString(test2));
}