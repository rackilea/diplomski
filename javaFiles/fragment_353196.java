@RunWith(Parameterized.class)
public class BehaviorTest {
    @Parameters
    public static Collection<Object[]> classesAndMethods() {
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[]{ Foo.class, Foo.class.getMethod("foo") });
        return list;
    }

    private Class clazz;
    private Method method;

    public BehaviorTest(Class clazz, Method method) {
         this.clazz = clazz;
         this.method = method;
    }

    @Test
    public void testBehavior() {
        // Do stuff
    }
}