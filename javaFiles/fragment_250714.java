package de.scrum_master.app;

public class Foo {
    public void doSomethingFooish() {
        fooTwo(22);
    }

    public void fooOne(Bar bar) {
        bar.doSomethingBarish();
        fooTwo(11);
    }

    public String fooTwo(int number) {
        return fooThree("xxx");
    }

    public String fooThree(String text) {
        return text + " " + text + " " + text;
    }
}