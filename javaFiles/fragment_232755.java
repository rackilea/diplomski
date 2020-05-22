<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="java.util.*,Controller.*,dbBean.*,Dbconnect.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <c:forEach items="${user}" var="element"> 
            <tr>
            <td>${element.id}</td>
            <td>${element.name}</td>
            <td>${element.password}</td>
            <td>${element.phoneno}</td>
            <td>${element.emailid}</td>
            <td><a href="ControllerTest?action=edit&userId=">Update</a></td>
            <td><a href="ControllerTest?action=delete&userId=">Delete</a></td>
            </tr>
        </c:forEach>
    </tbody>
    </table>
    <p>
    <a href="ControllerTest?action=insert">Add User</a>
    </p>
</body>
</html>