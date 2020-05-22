class A 
{
    B bInA;
    C cInA;

    public void foo(int someValue)
    {
         cInA = new C();
         bInA = new B();
         cInA.foo(bInA, someValue);
         System.out.println(bInA.value);
    }

    public static void main(String args[])
    {
         A myA = new A();
         myA.foo(123);
         // myA.bInA.value should be equal to xyz
    }
}

class B { int value; }

class C 
{
    public void foo(B bInA, int someValue)
    {
          bInA.value = someValue;
    }
}