<c:choose>
    <c:when test="${var1.equalsIgnoreCase(var2)}">
        Both are equal.
    </c:when>
    <c:otherwise>
        Both are not equal.
    </c:otherwise>
</c:choose>