@RequestMapping(value="/multiplebuttons", method = RequestMethod.POST)
public String processForm(  @Validated  ButtonForm buttonForm, BindingResult result,
        Map model) {
    System.out.println("Processing..........");             

    if (result.hasErrors()) {
        System.out.println("Has errors");
        return "multiplebuttons";
    }
    return "redirect:views";
}