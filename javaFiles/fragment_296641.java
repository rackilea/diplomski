@RunWith(JMockit.class)
public class SingletonTest {
    private Singleton instance;

    @Before
    public void initialise() {
        Deencapsulation.setField(Singleton.class, "instance", null);
        instance = Singleton.getInstance();
    }

    @Test
    public void testOne(final @Mocked SomeClass someClass) {
        instance.methodOne();
        new Verifications() {
            {
                SomeClass.fillListOne();
            }
        };
    }
    // ...other tests...
}