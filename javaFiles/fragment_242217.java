// static import allows for more concise code (createMock etc.)
import static org.easymock.EasyMock.*;

// other imports omitted

public class MyServletMock
{
   @Test
   public void test1()
   {
      // Step 1 - create the mock object
      HttpServletRequest req = createMock(HttpServletRequest.class);

      // Step 2 - record the expected behavior

      // to test true, expect to be called with "param1" and if so return true
      // Note that the method under test calls getParameter twice (really
      // necessary?) so we must relax the restriction and program the mock
      // to allow this call either once or twice
      expect(req.getParameter("param1")).andReturn("true").times(1, 2);

      // program the mock to return false for param2
      expect(req.getParameter("param2")).andReturn("false").times(1, 2);

      // switch the mock to replay state
      replay(req);

      // now run the test.  The method will call getParameter twice
      Boolean bool1 = getBooleanFromRequest(req, "param1");
      assertTrue(bool1);
      Boolean bool2 = getBooleanFromRequest(req, "param2");
      assertFalse(bool2);

      // call one more time to watch test fail, just to liven things up
      // call was not programmed in the record phase so test blows up
      getBooleanFromRequest(req, "bogus");

   }
}