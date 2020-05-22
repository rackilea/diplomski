<c:forEach items="${requestScope.AllUsers}" var="user" varStatus="loop">
    <tr>
        <td class="numberWidth">${loop.index + 1}</td>
        <td class="nameWidth" id="${user.key}">${user.value}</td>
        <td>
            <form action="InstitutionManagementServlet" method="post">
                <input type="submit" name="Deactivate" value="Deactivate" />
                <input type="hidden" name="key" value="${user.key}" />
            </form>
        </td>
    </tr>
</c:forEach>