<c:forEach var="row" items="${memberList}">
    <tr>
        <td>${row.firstname}</td>
        <td>${row.lastname}</td>
        <td>${row.username}</td>
        <td>${row.type}</td>
        <td><a href="AdminPanel.jsp" name="Edit">Habilitar usuario</a> </td>
    </tr>
</c:forEach>