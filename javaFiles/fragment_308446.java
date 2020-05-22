class Example
{
    public static void main (String[] args) throws java.lang.Exception
    {
        System.out.println("Ran at " + new java.util.Date());
    }

    static class A {
        private A() {
        }
    }
    static class B extends A {
        private B() {
            super();
        }
    }
}