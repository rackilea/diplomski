@RequestMapping(value="/login",method = RequestMethod.POST)  
 public ModelAndView loginResult(HttpServletRequest req,HttpServletResponse res, Model model){

    String message = "";
    String response = "";

     if(uname.equals(inf.getUsername())&&pwd.equals(inf.getPassword())&&dept.equals(inf.getDept())) {
                    req.getSession().setAttribute("uname",inf.getName());
        message = message1;
        response = "employeeLoginResult";
            }
         else if(uname.equals(inf2.getUsername())&&pwd.equals(inf2.getPassword())&&dept.equals(inf2.getDept())) {
                 req.getSession().setAttribute("uname",inf2.getName());
        message = message2;
        response = "adminLoginResult"; 
            }
            else{
        message = "Sorry Username Password Error";
        response = "index";
            }
    model.addAttribute("message", message);
    return response;
}