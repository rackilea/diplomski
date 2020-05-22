public static int foo(int x) {
    x++;
    if(x < 10) {
        foo(x);
    }
    return x;
}