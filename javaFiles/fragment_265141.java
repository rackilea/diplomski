public static void foo(A a)
{
   a.setx(13);
}

public static void main()
{
    A a = new A();
    a.setx(12);
    foo(a);
    System.out.println(a.getx());
}