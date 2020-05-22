@Layout("layouts/default.html")
@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
public String Dashboard() {
    ModelAndView mav = null;
    if (session.getAttribute("loginStatus") != "1") {
        return "redirect:/";
    } else {
        return "dashbaord.html";
    }

}