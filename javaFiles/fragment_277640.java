@RunWith(MockitoJUnitRunner.class)
public class MyTest
{
   @Mock
   private Socket socket;

   @Mock
   private OutputStream myOutputStream;

   @Captor
   private ArgumentCaptor<byte[]> valueCapture;

   @Test
   public void test01()
   {
     Mockito.when(socket.getOutputStream()).thenReturn(myOutputStream);

     //EXECUTE YOUR TEST LOGIC HERE

     Mockito.verify(myOutputStream).write(valueCapture.capture());
     byte[] writtenData = valueCapture.getValue();        
   }

}