public class TestGeneric<T>
{
    private Class<T> genClass;
    public TestGeneric(Class<T> t) {genClass = t;}
    public void get (Object arg)
    {
        if (!genClass.isInstance(arg)) {
            throw new ClassCastException();
        }
        T temp = (T) arg;

        System.out.println(temp.toString());

        return;
    }
}

TestGeneric<Integer> tg = new TestGeneric<Integer>(Integer.class);
tg.get("Bang!!!"); // Now that's a real Bang!!!