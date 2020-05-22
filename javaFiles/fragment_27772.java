@ResponseBody
public String login(HttpServlet request,HttpServletResponse){
  String username = request.getParameter("username");
  String password = request.getParameter("password");

  //do operation for authenticate user from database, I am assuming User Bean
  User user     = userDao.authenticate(username,password);
  if(user!=null){

    return "success";
  }else{

   return "error";
  }

}