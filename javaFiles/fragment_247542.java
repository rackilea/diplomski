<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<c:forEach var="i" items="${A.keySet()}">
   Key <c:out value="${i}"/>
   Value <c:out value="${A.get(i)}"/>
</c:forEach>
</body>
</html>