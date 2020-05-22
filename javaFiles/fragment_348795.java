@Controller
public class OfficerRegistrationController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowire // tells spring to populates that for us.
    private DivisionManager divisionManager;

    @Autowire
    private PositionManager positionManager;

    @Autowire
    private GenderManager genderManager;

    @Autowire
    private OfficerRegistrationValidation officerRegistrationValidation;

    @InitBinder("officers")
    protected void initBinder(WebDataBinder binder){
        //removes white spaces 
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));

        //formats date 
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        //By passing true this will convert empty strings to null
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
        dateFormat.setLenient(false);


        logger.info("Just before initBinder");
        binder.setValidator(officerRegistrationValidation);
    }

    @RequestMapping(value="officer_registration.htm", method = RequestMethod.GET)
    public ModelAndView loadPage(HttpServletRequest request, HttpServletResponse response,@ModelAttribute Officers officer, BindingResult result, ModelMap m, Model model) throws Exception {
        // ... 
    }

    @RequestMapping(value="officer_registration.htm", method=RequestMethod.POST)
    public ModelAndView handleRequest(@Valid @ModelAttribute Officers officer, BindingResult result, ModelMap m, Model model) throws Exception{
        // ...
    }

    @RequestMapping(value="validateUserName.htm", method=RequestMethod.GET)
    public @ResponseBody String validateUserName(@RequestParam String userName) throws Exception{
        // ...
    }
}

@Component
public class OfficerRegistrationValidation implements Validator {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowire
    ValidateUserNameManager validateUserNameManager;

    public boolean supports(Class<?> clazz) {
        return Officers.class.equals(clazz);
    }

    public void validate(Object target, Errors errors) {
        // ...
    }
}

@Service
public class ValidateUserNameManager implements ValidateUserNameIFace {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowire
    private OfficersDAO officerDao;

    public boolean doesUserNameExist(String userName) throws Exception {
        // ...
    }
}

@Repository
public class OfficersDAO {
    // ...
}