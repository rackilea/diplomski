<%@ page import="java.io.*,java.util.*, javax.servlet.*"%>
<%@ page import="javax.servlet.http.*"%>
<%
   System.out.println("HTTP method:" + request.getMethod());

   if("POST".equals(request.getMethod()) {
       System.out.println(request.getParameter("txtUserId"));
       System.out.println(request.getParameter("txtUserName"));
       System.out.println(request.getParameter("txtUserLastName"));

       //Do something with the parameters
   }
%>