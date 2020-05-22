public App() {
    Thing t = null;
    t = doStuff(t);
    System.out.println(t);
}

public Thing doStuff(Thing a) {
    a = new Thing();
    return a;
}