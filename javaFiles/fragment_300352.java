@Controller
public class HelloWorldController {
    @RequestMapping("/hello")
    public ModelAndView getHello() {
        return new ModelAndView("hello", "title", "hello world");
    }
}

public class HelloWorldControllerTest {
    private HelloWorldController controller;

    @Before
    public void setUp() {
        controller = new HelloWorldController();
    }

    @Test
    public void getHelloShouldUseHelloView() {
       assertThat(controller.getHello().getViewName()).isEqualTo("hello");
    }

    @Test
    public void getHelloShouldAddATitleModel() {
        assertThat(controller.getHello().getModel()).containsEntry("title", "Hello world");
    }
}