<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>Home Page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
    <h1>Testing access to java.util.Map using just EL</h1>
    <p><b>\${map.get(noValueInt)}</b>: ${map.get(noValueInt)}</p>
    <p><b>\${map[one]}</b>: ${map[one]}</p>
    <p><b>\${map[two]}</b>: ${map[two]}</p>

    <h1>Testing access to java.util.Map using JSTL and EL</h1>
    <p><b>&lt;c:out value="\${map.get(noValueInt)}" /&gt; </b>: <c:out value="${map.get(noValueInt)}" /></p>
    <p><b>&lt;c:out value="\${map[one]}" /&gt; </b>: <c:out value="${map[one]}" /></p>
    <p><b>&lt;c:out value="\${map[two]}" /&gt; </b>: <c:out value="${map[two]}" /></p>

    <h2>Printing java.util.Map keys and values (when Key = null, the <i>null</i> won't be shown)</h2>
    <c:forEach items="${map}" var="entry">
        <p><b>Key</b> = "${entry.key}", <b>Value</b> = "${entry.value}"</p>
    </c:forEach>
</body>
</html>