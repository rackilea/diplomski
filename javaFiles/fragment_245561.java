class Example
{
    static class A {
        public void search() {
            System.out.println(getClass());
        }
    }

    static class B extends A {}

    public static void main (String[] args) throws java.lang.Exception
    {
        new A().search();
        new B().search();
    }
}