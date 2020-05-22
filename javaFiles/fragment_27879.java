@RunWith(PowerMockRunner.class)
@PrepareForTest({A.class, Utils.class})
public class Atest {
    .
    .
    @Before
    public void setup() {
        .
        .
        mockStaticPartial(A.class, "myfunc");
        mockStatic(Utils.class);
        .
        .
    }

    public void testMyfunc1() {
        .
        .
        PowerMockito.when(A.mufync()).thenReturn(mockObj1);
        PowerMockito.when(Utils.getObj(mockParam)).thenReturn(mockObj);
        .
        .
        //More testing logic goes here
    }
    .
    .
}