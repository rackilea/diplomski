<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% 
    // Just for demo purposes. Do NOT use scriptlets in real work.
    request.setAttribute("items", java.util.Arrays.asList("foo", "bar", "waa"));
%>

<c:forEach items="${items}" var="item">
    <jsp:include page="include.jsp">
        <jsp:param name="item" value="${item}" />
    </jsp:include>
</c:forEach>