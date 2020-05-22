<%@page import="ejbtest.action.Trigger1"%>
<%@page import="ejbtest.utility.Utility"%>
<%@page import="javax.naming.InitialContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EJB Test</title>
    </head>
    <body>
    <%
        InitialContext ic = new InitialContext();
        Utility utility = (Utility) ic.lookup("java:module/Utility");
        out.println("count: " + utility.getCount() + "<br/><br/>");
        Trigger1 trigger1 = (Trigger1) ic.lookup("java:module/Trigger1");
        out.println("trigger1 count: " + trigger1.getTriggerCount());
    %>
    </body>
</html>