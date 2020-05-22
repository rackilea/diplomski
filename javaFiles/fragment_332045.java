private static void hello(String t) {
    t = "hello " + t;
}

private static void hello(CustomStringObject o) {
    o.str = "hello " + o.str;
}