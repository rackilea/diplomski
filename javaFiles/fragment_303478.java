package b;

public class B extends A {

    @Override
    public void myProcedure() {
        doSomethingB();
        // IT DOESN'T CALL super.myProcedure
    }

    private void doSomethingB() {}

}