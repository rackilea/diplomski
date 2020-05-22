String myString = assign(x);

String assign(String x) {
    try {
        return foo(x);
    } catch (Exception e) {
        return bar(x);
    }
}