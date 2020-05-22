import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class FastBigInteger
{
    public static void main(String[] args)
    {
        try
        {
            Class<?> c = Class.forName("java.math.MutableBigInteger");
            Constructor<?> con = c.getDeclaredConstructor(int.class);
            con.setAccessible(true);
            Object i = con.newInstance(1);
            Method m = c.getDeclaredMethod("mul", new Class[] { int.class, c });
            m.setAccessible(true);
            long before = System.nanoTime();
            for (int z = 2; z < 99999; ++z)
            {
                m.invoke(i, z, i);
            }
            long after = System.nanoTime();
            System.out.println("Duration "+(after-before)/1e9);

            String s = i.toString();
            int n = s.length();
            int lineWidth = 200;
            for (int j=0; j<n; j+=lineWidth)
            {
                int j0 = j;
                int j1 = Math.min(s.length(), j+lineWidth);
                System.out.println(s.substring(j0, j1));
            }
        }
        catch (Exception e)
        {
            System.err.println(e);
        }
    }
}