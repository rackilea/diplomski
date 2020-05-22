Boolean check=ls.loginValidate(login);

if(check==true) 
{
        RequestDispatcher rd=request.getRequestDispatcher("/Login.jsp");
        rd.forward(request, response);
}
else
{
RequestDispatcher rd=request.getRequestDispatcher("/error.jsp");
        rd.forward(request, response);
}