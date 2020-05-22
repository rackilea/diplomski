{"data": [
<c:forEach var="treeList" items="${JSONResult.jsonList}" varStatus='treeStatus'>
    { "title": "<c:out value='${treeList.name}' />", "key": "<c:out value='${treeList.id}' />" }
    <c:if test="${!(treeStatus.last)}">,</c:if>
</c:forEach>
]}