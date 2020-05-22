@ResponseBody
    public String login(HttpServlet request,HttpServletResponse,Map map){
      String username = request.getParameter("username");
      String password = request.getParameter("password");

      //do operation for authenticate user from database, I am assuming User Bean
      User user     = userDao.authenticate(username,password);
      if(user!=null){

        map.put("error",0);
      }else{

      map.put("error",1);
      }
     return "home";

    }