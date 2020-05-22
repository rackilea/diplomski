interface Thinker {
    public void think();
}

class A implements Thinker {
    public void think() { . . .}
}

class B implements Thinker {
    public void think() { . . .}
}

class C {
    public void processStuff(Thinker thinker) {
        thinker.think();
    }
}