@RunWith(PowerMockRunner.class)
public class MyTest {

    @Test
    public void testMethodThatDoesNotUseStatics() {
        // ...
    }

    @Test
    @PrepareForTest({Log.class})    // that's the way :)
    public void usesStatics() {
        // ...
    }

}