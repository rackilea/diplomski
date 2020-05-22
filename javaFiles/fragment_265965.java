<c:forEach var="entrant" items="${bean.entrants}">
    <tr>
        <td>${entrant.idEntrant}</td>
        <td>${bean.getGroupCode(entrant.idGroup)}</td>
        <td>${entrant.name}</td>
    </tr>
</c:forEach>