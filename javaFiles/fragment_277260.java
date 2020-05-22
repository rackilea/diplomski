package packageA;

public class A {
    private Inter myInter;

    public A(Inter myInter) {
        this.myInter = myInter;
    }

    public void doSomethingThatUsesInter() {
        System.out.println("Doing things with myInter");
        this.myInter.doSomething();
    }
}