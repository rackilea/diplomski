import java.lang.reflect.*;

class FieldContainer
{
    private static String woot;

    public static void showWoot()
    {
        System.out.println(woot);
    }
}

public class Test
{
    // Declared to throw Exception just for the sake of brevity here
    public static void main(String[] args) throws Exception
    {
        Field field = FieldContainer.class.getDeclaredField("woot");
        field.setAccessible(true);
        field.set(null, "New value");
        FieldContainer.showWoot();
    }
}