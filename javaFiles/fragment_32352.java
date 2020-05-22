<form action="InstitutionManagementServlet" method="post">   
    <c:forEach items="${requestScope.AllUsers}" var="user" varStatus="loop">
        <tr>
            <td class="numberWidth">${loop.index + 1}</td>
            <td class="nameWidth" id="${user.key}">${user.value}</td>
            <td><button type="submit" name="Deactivate" value="${user.key}">Deactivate</button></td>
        </tr>
    </c:forEach>
</form>