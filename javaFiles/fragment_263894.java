<c:choose>
    <c:when test="${empty prevValue}" />
        empty
    </c:when>
    <c:otherwise>
        not empty
    </c:otherwise>
</c:choose>