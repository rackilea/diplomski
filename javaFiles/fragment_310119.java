@RunWith(PowerMockRunner.class)
@PrepareForTest({Log.class})    // WARNING: HERE BE DRAGONS!
public class MyTest {

    @Test
    public void testMethodThatDoesNotUseStatics() {
        // ...
    }

    @Test
    public void usesStatics() {
        // ...
    }

}