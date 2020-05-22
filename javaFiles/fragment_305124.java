import java.lang.reflect.*;
import java.util.*;

public class Test
{
    public static void main(String[] args) throws Exception
    {
        Object o = new Test();
        Method m = o.getClass().getMethod("getDate");
        Date date = (Date) m.invoke(o);
        System.out.println(date);
    }

    public Date getDate()
    {
        return new Date();
    }
}