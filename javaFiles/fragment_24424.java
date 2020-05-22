@RunWith(MockitoJUnitRunner.class)
public class FooBarTest {

    @Mock
    List<String> codes;

    FooBar fooBarInstance = new FooBar();

    @Test(expected = Exception.class)
    public void shouldThrowExceptionWhenListHasTooManyElements() throws Exception {

        when(codes.size()).thenReturn(150);

        fooBarInstance.getMethod(codes);

    }
}