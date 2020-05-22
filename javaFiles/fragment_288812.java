import junit.framework.TestCase;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class TestTempServlet extends TestCase {

    public void test_bad_parameter() throws Exception {
        TemperatureServlet s = new TemperatureServlet();

        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();

        request.addParameter("Fahrenheit", "boo!");
        response.setContentType("text/html");
        s.doGet(request, response);
        //response.verify();//Method not in latest api.
        assertEquals("Invalid temperature: boo!",
                response.getContentAsString());
    }

    public void test_boil() throws Exception {
        TemperatureServlet s = new TemperatureServlet();
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();

        request.addParameter("Fahrenheit", "212");
        response.setContentType("text/html");
        s.doGet(request, response);
        //response.verify();//Method not in latest api.
        assertEquals("Fahrenheit: 212, Celsius: 100.0",
                response.getContentAsString());
    }

}