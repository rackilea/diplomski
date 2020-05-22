<c:if test="${not empty userEmail}">
    This block will be displayed when attribute `userEmail` is not empty.

    <c:choose>
        <c:when test="${userEmail == 'Ansari@precise-one.com'}">
            This block will be displayed when `userEmail` matches Ansari@precise-one.com.
        </c:when>
        <c:when test="${userEmail == 'test@liferay.com'}">  
            This block will be displayed when `userEmail` matches test@liferay.com.
        </c:when>
        <c:otherwise>
            There must always be a `c:otherwise` block. 
            This will be displayed when attribute `userEmail` doesn't match anything.
        </c:otherwise>
    </c:choose>
</c:if>
<c:if test="${empty userEmail}">
    This block will be displayed when attribute `userEmail` is empty.
</c:if>