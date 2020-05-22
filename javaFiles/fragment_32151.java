class Foo {
    static List<Character> abc;
    static {
        abc = new LinkedList<Character>();
        for (char c = 'A'; c <= 'Z'; ++c) {
            abc.add( c );
        }
    }
}