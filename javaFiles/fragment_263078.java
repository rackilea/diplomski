@RunWith(Parameterized.class)
public class YourComponentTest {

    @Rule public MockitoRule rule = MockitoJUnit.rule();
    @Mock YourDep mockYourDep;

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 { 0, 0 }, { 1, 1 }, { 2, 1 }, { 3, 2 }, { 4, 3 }, { 5, 5 }, { 6, 8 }  
           });
    }

    private int fInput;

    private int fExpected;

    public YourComponentTest(int input, int expected) {
        fInput = input;
        fExpected = expected;
    }

    @Test
    public void test() {
        // As you may surmise, this is not a very realistic example of Mockito's use.
        when(mockYourDep.calculate(fInput)).thenReturn(fExpected);
        YourComponent yourComponent = new YourComponent(mockYourDep);
        assertEquals(fExpected, yourComponent.compute(fInput));
    }
}