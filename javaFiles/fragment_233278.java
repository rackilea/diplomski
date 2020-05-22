class Bar extends Foo {
    int y; //shadows y field in Foo
    public Bar(int x) {
        super(x); //calling constructor of super class
        super.y = -5; //updating y field from super class
        this.y = 10; //updating y field from current class
    }
}