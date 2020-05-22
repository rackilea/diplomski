@RequestMapping(value = "/user/userAdd", method = RequestMethod.POST)
public String postUserAdd(@ModelAttribute("user") @Valid User user,
        BindingResult aaResult, Model aaModel, SessionStatus aaStatus) {
    if (aaResult.hasErrors()) {
        List<Country> llistCountry = this.caService.findCountryAll();
        aaModel.addAttribute("countrys", llistCountry);   

        return "/user/userAdd";
    } else {
        user = this.caService.saveUser(user);

        aaStatus.setComplete();
        return "redirect:/login";
    }
}