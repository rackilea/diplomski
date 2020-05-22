@RunWith(PowerMockRunner.class)
@PrepareForTest({InputHelper$11.class})
public class InputHelperTest {
    @Test
    public void anonymous_class_mocking works() throws Throwable {
        PowerMockito.spy(InputHelper.BZIP2_FACTORY);  // This line fails
    }
}