<c:forEach items="${branchList }" var="branch">
    <tr>
        <td>${branch.branch_name}</td>
        <c:forEach items="${branch.users}" var="user">
            <td>${user.first_name}</td>
        </c:forEach>         
    </tr>
</c:forEach>