<c:choose>
    <c:when test="${type eq "2"}">
        <c:set var="varclass" value="td-type2"/>
    </c:when>
    <c:otherwise>
        <c:set var="varclass" value="td-type1"/>
    </c:otherwise>
</c:choose>
<td class="${varClass}">