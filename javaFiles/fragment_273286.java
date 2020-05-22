@PrepareForTest(TestEnumerable.class)
@Test(groups = {"LoadableBuilderTestGroup"})
public class LoadableBuilderTest extends PowerMockTestCase {

 private TestEnumerable mockEnumerable;

 @SuppressWarnings("unchecked")
    @BeforeMethod
    public void setUp() {
        mockEnumerable = PowerMockito.mock(TestEnumerable.class);

    }
}