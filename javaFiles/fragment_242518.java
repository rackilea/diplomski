@Controller
@RequestMapping(value="/inhabitant")
public class PostController {

@Autowired
private InhabitantService inhabitantService;

//Method that displays the form page
@RequestMapping(value = "/create", method = RequestMethod.GET)
public String createForm(Model model ) {

    model.addAttribute("inhabitant", new Inhabitant()); // identifier should be same as modelattribute in your form "inhabitant"
    return "formpage"; // your form page name

}

// Method which will have the submitted data
// Validation is also done in this method
@RequestMapping(value="/create", method=RequestMethod.POST)
public String saveForm( @ModelAttribute("inhabitant") @Valid Inhabitant inhabitant, //@valid is used for validation use it If you are doing validation
        BindingResult result // use only if you are doing validation)
{
       // use only If you are doing validation
       // If validation fails users must return to the same form view
       if (result.hasErrors()){
           return "formpage";
       }

       //and save the submitted form data
       inahabitantService.saveInhabitant(inhabitant);
enter code here
       return "success"; // success.jsp is a success page that you will see after creating a inhabitant
}