<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://example.com/functions" prefix="f" %>
...
<select name="roles" multiple>
    <c:forEach items="${allRoles}" var="role">
        <option value="${role.id}" ${f:contains(user.roles, role) ? 'selected' : ''}>${role.name}</option>
    </c:forEach>
</select>