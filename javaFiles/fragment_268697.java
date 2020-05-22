...

@Autowired
private org.springframework.validation.Validator oneTimeFormValidator;

@RequestMapping(value="/payments/getTax.do", method=RequestMethod.POST)  
public String getTaxInfo(@Valid OneTimeForm command, BindingResult result) { 

     // validates conditional logic with OneTimeFormValidator
     oneTimeFormValidator.validate(command, result);

     if (result.hasErrors()) {
         // return a page
     }
     // do something else and return a page
}

...