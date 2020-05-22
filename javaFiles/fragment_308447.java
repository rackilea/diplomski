class Example
{
    public static void main (String[] args) throws java.lang.Exception
    {
        System.out.println("Ran at " + new java.util.Date());
    }
}
class A {
    private A() {
    }
}
class B extends A {
    private B() {
        super();    // COMPILATION FAILS HERE
    }
}