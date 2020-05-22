<form:form name="wblCaseType" method="post" modelAttribute="wblCaseType"action="${saveWblCaseType}">
<form:hidden path="wblCaseTypeId" />
....
<tr>
    <td><form:label path="createRoleIds"><liferay-ui:message key="roles"/></form:label></td>
    <c:forEach items="${roles}" var="role">
       <td><form:checkbox path="createRoleIdsArray" id="${role.roleId}" label="${role.name}" value="${role.roleId}" /></td>
    </c:forEach>
</tr>