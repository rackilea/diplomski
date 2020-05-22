<%-- iterate through the outer list --%>
<c:forEach var="innerList" items="${outerList}">
    <%-- iterate through the innerList --%>
    <c:forEach var="element" items="${innerList}">
        <%-- do what you want with the element --%>
    </c:forEach>
</c:forEach>