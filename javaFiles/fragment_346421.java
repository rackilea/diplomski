public void processA() {
    processB(instance1::m1, instance1::m2, instance1::m3);
}

public void processB(Consumer<String> c1, Consumer<String> c2, Consumer<String> c3) {
    c1.accept("Arg");
    c2.accept("Arg");
    c3.accept("Arg");
}