@Controller
public class ExampleController{

    @Autowired
    private ExampleController self;

    @RequestMapping(value = "URL", method = RequestMethod.POST)
    public ModelAndView controllerMethod(@ModelAttribute ModelAttribute reqModel, HttpServletRequest req, HttpServletResponse res) {

        try {
            response = self.executeService(param1, param2);

        } catch (Exception e) {

        }

    }
    public ResponseObject executeService(String param1, String param2){
        //Code....
    }
}