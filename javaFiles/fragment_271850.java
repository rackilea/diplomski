<c:if test="${not empty model.oldest}">
    <c:out value="${model.oldest}"/>
</c:if>
<c:if test="${not empty model.pending}">
    <c:out value="${model.pending}"/>
</c:if>