<c:choose>
    <c:when test="${autofocus}">
        <form:input autofocus="autofocus" />
    </c:when>

    <c:otherwise>
         <form:input />
    </c:otherwise>
</c:choose>