@RequestMapping(value="/logout",method=RequestMethod.GET)
public String closeSession(HttpServletRequest request){
    HttpSession session=request.getSession();  
    session.invalidate();  
    return "redirect:/";
}//closeSessione