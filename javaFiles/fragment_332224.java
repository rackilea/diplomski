@RunWith(Parameterized.class)
public class YourComponentTest {
    @Rule public MockitoRule rule = MockitoJUnit.rule();
    @Mock YourDep mockYourDep;

    @Parameters public static Collection<Object[]> data() { /* Return the values */ }

    public YourComponentTest(Parameter parameter) { /* Save the parameter to a field */ }

    @Test public void test() { /* Use the field value in assertions */ }
}