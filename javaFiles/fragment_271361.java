class Example
{
    public static void main (String[] args) throws java.lang.Exception
    {
        new C().test();
    }
}

class A {
    public int x = 1;
}

class B extends A {
    public int x = 2;
}

class C extends B {
    public int x = 3;

    public void test() {
        //There are two ways to put x in C from the method test():
        System.out.println("(Before) A.x = " + ((A)this).x);
        System.out.println("(Before) B.x = " + ((B)this).x);
        System.out.println("(Before) C.x = " + this.x);
        ((A)this).x = 4;
        System.out.println("(After) A.x = " + ((A)this).x);
        System.out.println("(After) B.x = " + ((B)this).x);
        System.out.println("(After) C.x = " + this.x);
    }
}