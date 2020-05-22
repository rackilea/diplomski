public class AB<T extends A&B>
{
    public final T v;

    ... 
        v = (T)Class.forName("test.messages.X").newInstance();
}