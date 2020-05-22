@RequestMapping(value = "/logout", method = RequestMethod.GET)
public String thanks(Model model,RedirectAttributes redirectAttributes,HttpSession session) {
 redirectAttributes.addAttribute("logout", "1234");
 model.addAttribute("parentLogin",null);
 session.removeAttribute("parentEmail");
 session.invalidate();
 return "redirect:parent-login";
}