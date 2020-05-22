<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  <html>
 <head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Simple Page which can't be access without Login</title>
 </head>
  <%
    String uname = (String) session.getAttribute("uname");
    if (null == uname) {
    session.setAttribute("errorMessage", "Login Failed ");
    response.sendRedirect("userLogged.jsp");
    }
 %>
 <body>
 <h4>Simple Page which can be access without Login </h4>
 </body>
 </html>