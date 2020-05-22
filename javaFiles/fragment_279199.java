@RequestMapping("dashboard")
public String goDashboard(Model model, Principal principal){
    UserDetails userDetails = (UserDetails)((Authentication)principal).getPrincipal()
    model.addAttribute("userDetails", userDetails);
    return "dashboard"; 
}