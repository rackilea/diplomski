package pkg1;

public interface SomeInterface {
    void m();

    public static SomeInterface getImplementation() {
        return new A();
    }
}

class A implements SomeInterface {
    @Override
    public void m() {}

    public void m2() {} // this one cannot be called from other packages

    private void m3() {} // this one might be used only in class A
}

package pkg2;

import pkg1.SomeInterface;

public class Main {
    public static void main(String[] args) {
        SomeInterface implementation = SomeInterface.getImplementation();
        implementation.m();
    }
}