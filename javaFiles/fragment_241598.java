@RequestMapping(value="save.htm", method = RequestMethod.POST)
    public ModelAndView handleSave(@Valid @ModelAttribute Crime crime, 
    BindingResult result,
    ModelMap m,
    Model model) throws Exception {


    if(result.hasErrors()){
           model.addAttribute("victimList",crime.getVictims());

    return new ModelAndView("*Your View*");
...............