public class ClassA
{
    int a,b;

    public ClassA(int a)
    {
        this.a = a;
    }
    public ClassA(int a,int b)
    {
        this(a);   // calling another constructor
        this.b = b;
    }
}