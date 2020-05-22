<c:url value="facultyview.jsp" var="url">
  <c:param name="name" value="${faculty.name}"/>
  <c:param name="total_seats" value="${faculty.total_seats}"/>
  <c:param name="budget_seats" value="${faculty.budget_seats}"/>
</c:url>
<li><a href="${url}">${faculty.name}</a></li>