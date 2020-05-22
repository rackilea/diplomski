@Controller
@CrossOrigin(origins = "*")
public class MovieCategoryController {

 @Autowired
 AppConfig appConfig;

    @RequestMapping(value = "/api/movieCategory/list", method = RequestMethod.GET)
    @ResponseBody
    public String listMovieCategories(ModelMap model, HttpServletResponse res, HttpServletRequest req) {

        System.out.println(appConfig.getTest());

        return "test";
    }