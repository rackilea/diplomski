package packageA;

public class A {
    private Inter myInter;

    public A() {
        this.myInter = ???; // What to do here?
    }

    public void doSomethingThatUsesInter() {
        System.out.println("Doing things with myInter");
        this.myInter.doSomething();
    }
}