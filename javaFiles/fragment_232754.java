<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="java.util.*,Controller.*,dbBean.*,Dbconnect.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Show All Users</title>
</head>
<body>
    <table border=1>
    <thead>
        <tr>
        <th>Id</th>
        <th>Name</th>
        <th>password</th>
        <th>phoneno</th>
        <th>emailid</th>
        <th colspan=2>Action</th>
        </tr>
    </thead>
    <tbody>
        <jsp:useBean id="users" type="java.util.ArrayList" scope="request" />
        <% for(int i = 0; i < users.size(); i+=1) { 
            UseBean user = (UseBean)users.get(i);
        %>
            <tr>
            <td><%= user.getID() %></td>
            <td><%= user.getName() %></td>
            <td><%= user.getPassword() %></td>
            <td><%= user.getEmailID() %></td>
            <td><%= user.getPhoneo() %></td>
            <td><a href="ControllerTest?action=edit&userId=<%= user.getID() %>" >Update</a></td>
            <td><a href="ControllerTest?action=delete&userId=<%= user.getID() %>">Delete</a></td>
            </tr>
        <% } %>
    </tbody>
    </table>
    <p>
    <a href="ControllerTest?action=insert">Add User</a>
    </p>
</body>
</html>