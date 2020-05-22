<c:forEach items="${param}" var="p">
    Param: ${p.key}=
    <c:forEach items="${p.value}" var="v" varStatus="loop">
        ${v}${loop.last ? '<br>' : ','}
    </c:forEach>
</c:forEach>