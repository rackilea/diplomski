@parser::members {private Set<String> mySet;
    public MyParser(CharStream input, Set<String> theSet) {
        this(input);
        mySet = theSet;
    }
}