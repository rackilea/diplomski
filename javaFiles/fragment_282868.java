public class Test
{
    StringBuffer b;

    public Test()
    {
        b = new StringBuffer();
    }

    public String someMethod()
    {
        b.append("Some Method");
        return(b.toString());
    }
}