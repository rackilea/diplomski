private class Blah<T> { }
private class Giraffe { }

public Test_1() {
    Blah<Giraffe> f = new Blah<Giraffe>();
    addThing2(f);
}

public <T> void addThing2(Blah<T> obj) {
    process(obj);
}

public void process(Blah<?> obj) { }