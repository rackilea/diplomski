public class ReflectionTest {

    @Test
    public void callB() throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        A myA = new A();
        myA.callB();
    }


}