public class BBB
{
public static class a {

}

private static class MyCL extends ClassLoader
{
    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException
    {
        System.out.println("Hi, " + a.class.getName());
        return a.class;
    }
}

public static void main(String[] args) throws ClassNotFoundException
{
    MyCL cl = new MyCL();

    System.out.println(Class.forName("com.asg.util.BBB$a", true, cl));

}