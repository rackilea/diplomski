<c:forEach var="person" items="${persons}" varStatus="status">
    <tr>
        <c:set var="personFormId" value="person${status.index}"/>
        ....
        <form id="${personFormId}" action="${deleteUrl}" method="POST">
            <input id="id" name="id" type="hidden" value="${person.id}"/>
        </form>

        <td>${person.firstName}</td>
        <td>${person.lastName}</td>
        .... 
    </tr>
</c:forEach>