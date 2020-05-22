<c:forEach items="${ requestScope['users'] }" var="users">

<form action="<%=response.encodeURL(request.getContextPath() + "delete.html") %>" method="POST"> 
<input type="hidden" name="id" value="<c:out value="${ usersId.id }"/>" />
<input type="SUBMIT" value="Delete User" /></form>
</c:forEach>