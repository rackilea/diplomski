import java.lang.reflect.*;
class ChangeFinal 
{
    private final int x = 20;//compile time constant
    public static void change(ChangeFinal cf)
    {
        try
        {
            Class clazz = ChangeFinal.class;
            Field field = clazz.getDeclaredField("x");
            field.setAccessible(true);
            field.set(cf , 190);//changed x to 190 for object cf
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    public static void main(String[] args) 
    {
        ChangeFinal cf = new ChangeFinal();
        System.out.println(cf.x);//prints 20
        change(cf);
        System.out.println(cf.x);//prints 20
    }
}