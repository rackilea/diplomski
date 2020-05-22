@RequestMapping(value = "/processLogin", method = RequestMethod.POST)
public ModelAndView processLogin(HttpServletRequest request,HttpServletResponse response) {
    String userName=request.getParameter("username");  
    String password=request.getParameter("password"); 

    if (loginservice.checklogin(userName,password)) {

            /* ModelAndView success = new ModelAndView("success");*/
            HttpSession session = request.getSession(true);

            ModelAndView success = new ModelAndView("success");
            List<Users_main>  user = userprofile.userdetails(userName);
            success.addObject("username", userName);
            success.addObject("user",user);
            session.setAttribute("user",user);
            return success;
        } else {
            ModelAndView error = new ModelAndView("error");
            return error;
        }

}