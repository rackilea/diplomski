class foo {
    int bar = 42;

    int doStuff(){
        int x = 1;
        x += bar;
        x += bar;
        x += bar;
        return x;
    }
}