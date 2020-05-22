public <T> void go(T x) {
    if (x instanceof String)
        pr((String)x);
    else
        pr(x);
}