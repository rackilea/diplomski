@RunWith(PowerMockRunner.class)
@PrepareForTest({Application.class})
public class ApplicationTest {

    @Test
    public void test() throws Exception {
        Addition addition = PowerMockito.mock(Addition.class);
        PowerMockito.when(addition.sum(ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt())).thenReturn(15);

    PowerMockito.whenNew(Addition.class).withNoArguments().thenReturn(addition);

        Application applicationMock = PowerMockito.mock(Application.class);
        when(applicationMock.doOperation(anyInt(), anyInt())).thenCallRealMethod();
        int res = applicationMock.doOperation(1, 5);

        assertEquals(res, 15);
    }
}