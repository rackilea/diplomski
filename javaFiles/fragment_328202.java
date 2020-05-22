package abstractpkg;

public class Test {
    public static void main(String[] args) {
        C c = new C();    // Compile-time error. C is abstract
        B b = new B();    // OK: B is concrete 
    }
}

abstract class A{
    abstract void methA();
    public void methB(){

    }
}

/**
 * Non-abstract class extending asbtract class.
 * */
class B extends A{
    /*
     * Since it is Non-abstract class, it must provide impl of abstract method because without impl of 
     * method Object of class can't be created.
     * */
    void methA() {

    };

    /*
     * This overriding is optional, since it's impl is already existing in super class.
     * If class B has to give spl impl then B should override this method
     * */
    @Override
    public void methB() {
        // TODO Auto-generated method stub
        super.methB();
    }
}


abstract class C extends A{
    /*
     * Since C is also abstract it may or may not override the method. 
     * */

    /*
     * Overriding and providing impl is optional.
     * */
    @Override
    void methA() {

    }
}