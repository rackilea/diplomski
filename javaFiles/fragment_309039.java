public class TestSomething {
    @Rule
    public final JUnitRuleMockery context = new JUnitRuleMockery();

    @Mock
    private MyInterface interface;

    @Test
    public void testTheThing() {
        context.checking(new Expectations{{

         }});
        // etc.
    }