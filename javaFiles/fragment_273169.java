@Controller
@RequestMapping("/whatever")
public class MyClass {

    @Autowired
    private final ServletContext context;

    @RequestMapping(method = RequestMethod.GET)
    public String get(ModelMap model) {
        Random rand = new Random();
        List<String> images = new ArrayList<String>(context.getResourcePaths("/images"));
        model.addAttribute("randomImage", images.get(rand.nextInt(images.size())));
        return "myPage";
    }

}