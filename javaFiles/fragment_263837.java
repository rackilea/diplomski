<table>
    <c:forEach items="${userRecords}" var="user">
        <tr>
            <td>${user.user_first_name}</td>
            <td>${user.user_middle_name}</td>
        </tr>
    </c:forEach>
</table>