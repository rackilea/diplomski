@RunWith(MockitoJUnitRunner.class)
public class MyTest {

    @Spy
    private ClassUnderTest instance;

    public void test() {
        // SETUP
        String expectedA = "test value A";
        String expectedB = "test value B";
        boolean expectedC = true;
        doNothing().when(instance).doAction(expectedA , expectedB, expectedC);

        // CALL
        instance.doActionOne(expectedA, expectedB);

        // VERIFY
        verify(instance, times(1)).doAction(expectedA , expectedB, expectedC);
    }