@RequestMapping(value="/", method=RequestMethod.POST)
public String checkPersonInfo(@ModelAttribute(value="nominee") @Valid Nominee nominee,
                              BindingResult bindingResultNominee,
                              @ModelAttribute(value="submitter") @Valid Submitter submitter,
                              BindingResult bindingResultSubmitter) {
    LOG.info("Nominee to string: " + nominee.toString());
    LOG.info("Submitter to string: " + submitter.toString());
    if (bindingResultNominee.hasErrors() || bindingResultSubmitter.hasErrors()) {
        return "form";
    }

    return "redirect:/success";
}