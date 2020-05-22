public
class ReflectiveCall
{
    public static
    void main(String args[])
    {
        ReflectiveCall m = new ReflectiveCall();
        String h = "foo";

        while (true)
        {
            Method method;
            try
            {
                method = m.getClass().getMethod(h);                   
                method.invoke(m);
            }
            catch (SecurityException e)
            {
            }
            catch (NoSuchMethodException e)
            {
            }
            catch (IllegalArgumentException e)
            {
            }
            catch (IllegalAccessException e)
            {
            }
            catch (InvocationTargetException e)
            {
            }
        }
    }

    public
    void foo()
    {
        System.out.println("foo");
    }
}