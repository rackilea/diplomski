package de.scrum_master.app;

public class Bar {
    public void doSomethingBarish() {
        barTwo(22);
    }

    public void barOne(Foo foo) {
        foo.doSomethingFooish();
        barTwo(11);
    }

    public String barTwo(int number) {
        return barThree("xxx");
    }

    public String barThree(String text) {
        return text + " " + text + " " + text;
    }
}