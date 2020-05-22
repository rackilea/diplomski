public class Catalog
{
    public interface I
    {
    }

    public enum T1 implements I
    {
        A, B, C;
    }

    public enum T2 implements I
    {
        D, E, F;
    }

    public static void main (String [] args) throws Exception
    {
        String name = "T1";

        Class <? extends I> c =
            (Class <? extends I>)Class.forName (
                Catalog.class.getName () + "$" + name);

        I [] values = (I [])c.getMethod ("values").invoke (null);

        for (I i: values)
            System.out.println (i);
    }
}