@Controller
public class MainPageController { // or whatever it happens to be called

    @Autowired
    private SiteSettingsService siteSettingsService;

    @RequestMapping(value="/mainPage", method=RequestMethod.GET)
    public String displayMainPage(Model model) {
        SiteSettings siteSettings = siteSettingsService.getSiteSettings();
        // Make the property available to the view
        model.addAttribute("authenticationRequired", siteSettings.isAuthenticationRequired());
        return "mainPage";
    }
}