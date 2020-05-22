<c:forEach var="queryResult" items="${queryResult}" varStatus="status">
    <tr>
       <td>${status.index + 1}</td>
       <td><fmt:formatNumber value="${queryResult.itemId}" minFractionDigits="2"/></td>
       <td>${queryResult.itemNumber}</td>
       <td>${queryResult.description}</td>
       <td>${queryResult.lifeCyclePhase}</td> 
    </tr>
</c:forEach>