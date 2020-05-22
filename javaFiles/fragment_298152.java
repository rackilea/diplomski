<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<body>
    <c:if test="${!isActivityVP && isBuy && isOwner}">
        Hello
    </c:if>
</body>