<c:url value="search" var="url">
    <c:param name="q" value="${q}"/>
    <c:forEach var="field" items="${fq}" varStatus="loop">
        <c:if test="${not loop.last}">
            <c:param name="fq" value="${field}"/>
        </c:if>
    </c:forEach>
</c:url>