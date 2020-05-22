public class B0
{
    int value;
    public B0(int i){ value=i; }

    public class B extends A
    {
        protected void init()
        {
            System.out.println("value="+value);
        }
    }
}