<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test</title>
</head>
<body>
    <sf:form commandName="person" action="/appname/handlePost.html" method="post">
        <sf:input path="firstName"/>
        <sf:input path="department.departmentName"/>
        <sf:button name="Submit">Submit</sf:button>
    </sf:form>
</body>
</html>