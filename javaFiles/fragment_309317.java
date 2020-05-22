@RequestMapping(value="/", method=RequestMethod.POST)
public String checkPersonInfo(@ModelAttribute(value="nominee") @Valid Nominee nominee,
                              @ModelAttribute(value="submitter") @Valid Submitter submitter,
                              BindingResult bindingResult, @Valid Model model) {
    LOG.info("Nominee to string: " + nominee.toString());
    LOG.info("Submitter to string: " + submitter.toString());
    LOG.info("bindingResult to string: " + bindingResult.toString());
    if (bindingResult.hasErrors()) {
        return "form";
    }

    return "redirect:/success";
}