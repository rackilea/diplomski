String user = request.getParameter("user");
   String pass = request.getParameter("pass");

   Company co = Dbcon.DB_login1(user , pass);

   if (co == null){
       response.sendRedirect("home.jsp?err=1");
       }
   else{
       response.sendRedirect("home.jsp");
   }