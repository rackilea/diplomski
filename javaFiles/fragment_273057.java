<c:url var="accountUrl" value="/account.action">
    <c:param name="userId" value="${currentUserId}"/>
</c:url>
<fmt:message key="msg1">
    <fmt:param value="${accountUrl}"/>
</fmt:message>