<c:choose>
    <c:when test="${fn:toLowerCase(var1) == fn:toLowerCase(var2)}">
        Both are equal.
    </c:when>
    <c:otherwise>
        Both are not equal.
    </c:otherwise>
</c:choose>