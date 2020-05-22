public abstract class CustomClass {
    public void myMethod(){ // this is the template method
        // The common things
        theDifferentThings();
    }

    public abstract void theDifferentThings();
}

public class Impl1 extends CustomClass {
    @Override
    public void theDifferentThings() {
        // Do something
    }
}

public class Impl2 extends CustomClass {

    @Override
    public void theDifferentThings() {
        // Do something else
    }
}