public App() {
    Thing t = null;
    doStuff(t);
    System.out.println(t);
}

public void doStuff(Thing a) {
    a = new Thing();
}