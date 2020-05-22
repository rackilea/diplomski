<c:forEach items="${empList}" var="employee">
    <tr>
        <td>Employee ID: <c:out value="${employee.eid}"/></td>
        <td>Employee Pass: <c:out value="${employee.ename}"/></td>  
    </tr>
</c:forEach>