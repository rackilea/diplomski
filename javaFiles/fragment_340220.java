UserBean user = new UserBean();
 String role = "";
 user.setUserName(request.getParameter("un"));
 user.setPassword(request.getParameter("pw"));

 role = UserDAO.login(user);//to get role either A for admin or U for user

if(role.equals("A"))//admin
 {
      HttpSession session = request.getSession(true);       
      session.setAttribute("currentSessionUser",user); 
      response.sendRedirect("AllPost"); //logged-in page            
 }

 else if(role.equals("U"))//user
 {          
      HttpSession session = request.getSession(true);       
      session.setAttribute("currentSessionUser",user); 
      response.sendRedirect("AllCustomer"); //logged-in page            
 }     

 else 
      response.sendRedirect("indexinvalid.jsp"); //error page