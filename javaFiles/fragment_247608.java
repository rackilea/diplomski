<table>
    <c:forEach items="#{theList}" var="item" varStatus="i">
    <c:if test="${i.index % 3 == 0 or i.begin}">
    <tr>
    </c:if>
        <td>${item.field}</td>
    <c:if test="${i.index % 3 == 0 or i.last}">
    </tr>
    </c:if>
    </c:forEach>
</table>