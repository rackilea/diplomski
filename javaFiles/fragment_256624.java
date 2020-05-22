class SelfBounded1 extends SelfBounded<SelfBounded1> {}

public class SelfBoundedMainJava {
    public static void main(String[] args) {
        // or SelfBounded<?> selfBounded
        SelfBounded1 selfBounded = new SelfBounded1();
        System.out.println(selfBounded.testField);
        System.out.println(selfBounded.testMethod().testField);
    }
}