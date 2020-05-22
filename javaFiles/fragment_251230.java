if(login_validacao.getLogin()==null && login_validacao.getSenha()==null)
    {
        response.sendRedirect("login.jsp?vazio=" + URLEncoder.encode(vazio, "UTF-8"));

    }
       else if(login_validacao.getLogin().equals(request.getParameter("login")) 
      & login_validacao.getSenha().equals((request.getParameter("senha"))))
   {

     RequestDispatcher rd=request.getRequestDispatcher("/index.jsp");
     rd.forward(request, response);
   }
      else
   {
      response.sendRedirect("login.jsp?incorretos=" + URLEncoder.encode(incorretos, "UTF-8"));
    }