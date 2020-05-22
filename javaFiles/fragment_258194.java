@RunWith(PowerMockRunner.class)
@PrepareForTest({ MyResource.class })
public class MyResourceTest {

   @Test
   public void testGetIt()() {
     MyResource mr = new MyResource();

     //Setup mock
     A mockA = PowerMockito.mock(A.class);

     String mockReturn = "Some String";

     //Stub new A() with your mock
     PowerMockito.whenNew(A.class).withAnyArguments().thenReturn(mockA);
     PowerMockito.doReturn(mockReturn).when(mockA).getWeather();
     String ret = mr.getIt();

     //asserts go here
   }
}