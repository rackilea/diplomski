<c:if test="${not empty result}">
  <c:forEach var="e" items="${result}" >
     <c:out value="${e.username}"/>
      </c:forEach>


</c:if>