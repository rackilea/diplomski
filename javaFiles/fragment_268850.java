@Controller
public class ContentController {

    @ModelAttribute
    public void addCommon(Model model){
        Locale locale2 = LocaleContextHolder.getLocale();
        String lang_name = locale2.getDisplayLanguage(); 
        model.addAttribute("language",lang_name);       

        //... add another common attributes
    }

    @RequestMapping("/index")
    public ModelAndView sriWap(){
        return new ModelAndView("sriWap");
    }

    ....
}