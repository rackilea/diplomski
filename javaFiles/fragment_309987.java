public enum Foo {
    BAR (0),
    BAZ (1),
    FII (10);

    private final int index;   

    Foo(int index) {
        this.index = index;
    }

    public int index() { 
        return index; 
    }

}