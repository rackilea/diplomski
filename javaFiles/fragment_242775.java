@PrepareForTest(KeyManagerFactory.class)
@RunWith(PowerMockRunner.class)
public class FooTest {

   @Test
   public void testGetKeyStore() throws Exception {
      PowerMockito.mockStatic(KeyManagerFactory.class);
      when(KeyManagerFactory.getInstance(anyString())).thenThrow(new NoSuchAlgorithmException());
   }
}