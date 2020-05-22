class foo {
    int bar = 42;

    int getBar() { return bar; }

    int doStuff(){
        int x = 1;
        x += getBar();
        x += getBar();
        x += getBar();
        return x;
    }
}