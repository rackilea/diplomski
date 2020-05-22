public class Outer {
    private int privateField;
    public int publicField;

    private void privateFoo() {}
    public void publicFoo() {}

    private class Inner {
        void bar() {
            privateFoo();
            publicFoo();
            System.out.println("privateField = " + privateField);
            System.out.println("publicField = " + publicField);
        }
    }
}