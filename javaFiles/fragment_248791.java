@Controller
public class PersonConroller{

    @Autowired
    private PersonService service;

    public String savePerson(@ModelAttribute Person person, ModelMap model){
        try{
            service.savePerson(person);
        }catch(CustomValidatorException e){
            model.addAttribute("errors", e.getBindingResult());
            return "viewname";
        }
        return "viewname";
    }

}