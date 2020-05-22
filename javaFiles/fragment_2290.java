if(null == session.getAttribute("LoginUser")){  
         //no logged in user
         RequestDispatcher rd=request.getRequestDispatcher("login.jsp"); //replace with your login page  
           rd.forward(request,response);    
           return;
    }else{
         //user attribute is not null so logout
        session.invalidate();
     }