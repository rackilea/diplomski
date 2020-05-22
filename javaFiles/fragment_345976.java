package Parent;
public abstract class A {
    public Object reflect(String parameter) throws NoSuchFieldException, IllegalAccessException{
        Class cl = getClass();
        java.lang.reflect.Field f = cl.getDeclaredField(parameter);
        f.setAccessible(true);
        return f.get(this);
    }
}