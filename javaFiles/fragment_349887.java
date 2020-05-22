<% 
if(session.getAttribute("username") == null)
{
response.sendRedirect("../wa_login/login.jsp");
}
%>