@RequestMapping(value="/registerConfirmation", method = RequestMethod.POST)
public String confirmRegister(@Valid @ModelAttribute("form") RegistrationForm form, BindingResult result, RedirectAttributes attr){
     logger.info("Sending registration data");
     if(result.hasErrors()){
       attr.addFlashAttribute("org.springframework.validation.BindingResult.form", result);
       attr.addFlashAttribute("form", form);
       return "redirect:/register";
     }
     //more code here    
     return "redirect:/registerConfirmation";
}