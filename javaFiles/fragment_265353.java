class A
{
    int a;
    A(int a)
    {
        this.a=a;
    }
}

class B extends A
{
    B(int a)
    {
        this.a=a;
    }
}

class C 
{
    public static void main(String args[])
    {
        B obj=new B(20);
        System.out.println("a = "+obj.a);
    }
}