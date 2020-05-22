<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index</title>
</head>
<body>
    <form action="./ServletGuardar.do" method="post">
        Name<input type="text" name="name">
        <input type="submit" name="save" value="Save">
    </form>
    <hr>
    <form action="/ServletGuardar.do" method="post">

    Names<select name="database1">
        <c:forEach items="${list}" var="databaseValue">
            <option value="${databaseValue}">
                ${databaseValue}
            </option>
        </c:forEach>
    </select>

    </form>
</body>
</html>