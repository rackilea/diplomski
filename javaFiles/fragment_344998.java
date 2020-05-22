<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"     "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EHCache</title>
</head>
<body>
<h1>EHCache</h1>

<p><a href="/tools/ehcache/clear?name=all">Clear All</a></p>
<c:forEach items="${managerMap}" var="manager">
<h2>Manager: '${manager.key}'</h2>

    <c:forEach var="cacheMap" items="${manager.value}">
        <h3>Cache: '${cacheMap.key}'</h3>
        <p><a href="/tools/ehcache/clear?cacheManagerName=${manager.key}&cacheName=${cacheMap.key}">clear</a></p>

        <c:forEach var="peerInfoMap" items="${cacheMap.value}">
            <li>peer name = ${peerInfoMap.key} peer status = ${peerInfoMap.value}</li>
        </c:forEach>    
    </c:forEach>


</c:forEach>

</body>
</html>