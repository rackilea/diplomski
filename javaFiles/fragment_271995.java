@RunWith(PowerMockRunner.class)
@PrepareForTest({SecureRandom.class, ExampleClass.class})
public class ExampleClassTest {

    private ExampleClass example = new ExampleClass();

    @Test
    public void aTest() throws Exception {

        SecureRandom mockRandom = Mockito.mock(SecureRandom.class);
       PowerMockito.whenNew(SecureRandom.class).withNoArguments().thenReturn(mockRandom);
        Mockito.when(mockRandom.nextInt(Mockito.anyInt())).thenReturn(3, 0);
        example.method();
   }
}