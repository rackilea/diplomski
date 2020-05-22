<c:catch var="ex">
    <fmt:formatDate value="${attribute.value}" pattern="yyyy-MM-dd HH:mm:ss"/>
</c:catch>
<c:if test="${not empty ex}">
    ${attribute.value}
</c:if>