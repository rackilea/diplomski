<form:form modelAttribute="roleList" method="post">
    <table>
        <thead>
            <tr>
                <th style="width: 80%;">Role</th>
                <th>Select</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${roleList.roles}"
                var="role" varStatus="status">
                <tr>
                    <td>role.name</td>
                    <td><form:checkbox
                            path="roles[${status.index}].selected" /></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</form>