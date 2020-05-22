import java.lang.reflect.Field;
import java.util.ArrayList;

class Private {
    private int i = 20;
    public String s = "java";
    private String name = "Object";
    private ArrayList<String> list = new ArrayList<String>()
    {
        {
            add("Hello");add("World");
        }
    };
}
public class Tester
{
    public static void main(String[] st)throws Exception
    {
        Private  p = new Private();
        Field[] fs = p.getClass().getDeclaredFields();
        for (Field f : fs )
        {
            f.setAccessible(true);
            System.out.println(f.get(p));
        }
    }
}