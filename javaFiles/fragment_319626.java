<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Test</title>
</head>
<body>
    <spring:eval expression="T(java.net.URLDecoder).decode(password)" var="decodedPassword"></spring:eval>
    <form:input id="pass" path="password" value="${decodedPassword}" htmlEscape="true" />
</body>
</html>