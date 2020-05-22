import org.junit.Test;
import org.junit.Assert;
import org.springframework.web.servlet.ModelAndView;

public class HelloControllerTest {
   @Test
   public void testHelloController() {
       HelloController c= new HelloController();
       ModelAndView mav= c.handleRequest();
       Assert.assertEquals("hello", mav.getViewName());
       ...
   }
}