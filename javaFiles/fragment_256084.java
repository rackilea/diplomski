<table>
    <tr>
        <c:forEach items="names" var="name" varStatus="i">
            <c:if test="${!i.first && !i.last && i.index % 3 == 0}">
                </tr>
                <tr>
            </c:if>
            <td><c:out value="${name}" /></td>
        </c:forEach>
    </tr>
</table>