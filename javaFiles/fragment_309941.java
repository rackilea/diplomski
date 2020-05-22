public class Facade {
    private A mA = new A();
    private B mB = new B();

    private void doB() {
        mB.doB();
    }

    private void doA() {
        mA.doA(); // as long as these are visible
    }    
}