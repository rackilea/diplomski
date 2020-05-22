// first request
@RequestMapping("/signup")
public String showSpitterForm(Model model) {
    model.addAttribute("spitter", new SpitterModel());
    return "signup";
}

/*
 * Form submission for spitter registration
 */
@RequestMapping(value = "/signup", method = RequestMethod.POST)
public String addSpitterFromForm(
        @Valid @ModelAttribute("spitter") SpitterModel spitterModel,
        BindingResult bindingResult, HttpSession session,
        HttpServletRequest request) {
    if (bindingResult.hasErrors()) {
        return "signup";
    }  else {
        saveSpitter(spitterModel, session
                .getServletContext().getRealPath("/resources/upload"));
        return "redirect:list";
    }
}