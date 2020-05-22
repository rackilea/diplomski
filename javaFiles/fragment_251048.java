class A {
}

class B {
    public B(A a) {

    }
}

class  Test
{
    public static void main (String[] args) 
    {
        A a = new A();
        B b1 = new B(a);

        B b2 = new B(new A());
    }
}