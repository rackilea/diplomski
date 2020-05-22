int count=0;
try {
        Accounts bean = new Accounts();
        bean.setUsername(request.getParameter("uname"));
        bean.setName(request.getParameter("fname"));
        bean.setEmail(request.getParameter("email"));
        bean.setPassword(request.getParameter("password"));
        AccountsDAO aO = new AccountsDAO();
        count=aO.addAccount(bean);
        if(count>0){
        response.sendRedirect("Stream.jsp"); \\Success condition here
        }
        else{
         response.sendRedirect("file.jsp");   \\ failure condition here
       }
    }
    catch(Exception e)
{
system.out.print(e);
}