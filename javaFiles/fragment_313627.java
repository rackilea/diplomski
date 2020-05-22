@RequestMapping(method = RequestMethod.POST) 
public /* or other return type */ String registerOfficer(@Valid @ModelAttribute Officer officer, BindingResult errors /*, more parameters */) {
    officerRegistrationValidation.validate(officer, errors);
    if (errors.hasErrors()) {
        ...// do something
    }
    ...// return something
}