@RunWith(PowerMockRunner.class)
@PrepareForTest({B.class})
public class BTest {

    @Test
    public void testB() {
        B a = Mockito.mock(B.class);
        PowerMockito.mockStatic(B.class);
        Mockito.when(B.getA()).thenReturn(a);
    }
}