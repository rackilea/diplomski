public class SampleClass {

public SampleClass() {
}

private void sampleClassMethod() {
    A a = new A();
    a.acceptB(new B());
}

private class A {
    public void acceptB(B bObject) {
        System.out.println(bObject.memberVar1);
    }

}

private class B {
    private int memberVar1 = 5;
}

}