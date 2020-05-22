@Controller
@SessionAttributes("userRoles")
public class SigninController {
    @RequestMapping(value = "customer_signin", method = RequestMethod.GET)
    public String customerSignin(Model model, HttpServletRequest request) {
        Set<String> userRoles = AuthorityUtils.authorityListToSet(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        model.addAttribute("userRole", userRoles);

        if(request.getQueryString() != null){
            model.addAttribute("error", "1");
        }
        return "signin/customer_signin";
    }


    @RequestMapping(value = "admin_signin", method = RequestMethod.GET)
    public String adminSignin(Model model, HttpServletRequest request) {
    Set<String> userRoles = AuthorityUtils.authorityListToSet(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        model.addAttribute("userRole", userRoles);
        if(request.getQueryString() != null){
            model.addAttribute("error", "1");
        }
        return "signin/admin_signin";
    }
}