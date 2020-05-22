@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/path/to/servlet-context.xml" })
public class FooControllerTest {

    @Autowired
    private RequestMappingHandlerMapping handlerMapping;

    @Autowired
    private RequestMappingHandlerAdapter handleAdapter;

    @Test
    public void fooControllerTest() throws Exception{

        // Create a Mock implementation of the HttpServletRequest interface
        MockHttpServletRequest request = new MockHttpServletRequest();

        // Create Mock implementation of the HttpServletResponse interface
        MockHttpServletResponse response = new MockHttpServletResponse();

        // Define the request URI needed to test a method on the FooController
        request.setRequestURI("/foo/bar");

        // Define the HTTP Method
        request.setMethod("GET");

        // Get the handler and handle the request
        Object handler = handlerMapping.getHandler(request).getHandler();
        ModelAndView handleResp = handleAdapter.handle(request, response, handler);

        // Test some ModelAndView properties
        ModelAndViewAssert.assertViewName(handleResp ,"bar");
        assertEquals(200, response.getStatus());
    }
}