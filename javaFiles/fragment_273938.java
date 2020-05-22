@Controller
public void MyController {

    @Autowired
    private MyServiceInterface myService;

    @RequestMapping(value="myUrl")
    public ModelAndView displayPage() {
       //do some stuff
        return new ModelAndView("myView").addObject("myService", myService);
    }
}