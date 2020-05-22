@Controller
public class FormController {

     @Autowired
     final private FormValidator formValidator;

     @InitBinder("form")
     protected void initBinder(WebDataBinder binder) {
        // correct
        binder.addValidators(formValidator);
        // wrong
        //binder.setValidator(formValidator);
    }

    ...

    @RequestMapping(value = "/formsubmit", method = RequestMethod.POST)
    public ModelAndView handleForm(@Validated final Form form, final BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ...
            // returns the model
        }
    ...
    }
}