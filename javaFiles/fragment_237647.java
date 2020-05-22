<c:forEach var="phase" items="${phaseList}">
    <c:forEach var="tache" items="${phase.taches}">
        <tr>
            <td>${tache.name}</td>
        </tr> 
    </c:forEach>
</c:forEach>