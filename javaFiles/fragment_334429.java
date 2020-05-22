@Service
@Transactional
public class DriveQuickstartImpl implements DriveQuickstart{

    // Other stuff...

    @Autowired 
    private GoogleAuthorization helper;


    @RequestMapping(value = "/getgooglelogin")
public String getGoogleLogin(HttpServletRequest request, HttpServletResponse response, HttpSession session,Model model) {

       // use "helper"
}