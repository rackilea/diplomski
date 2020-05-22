<c:choose>
  <c:when test="${user.organizationId == 1}">
        <!-- do something -->
  </c:when>
  <c:otherwise>
        <!-- do something different -->
  </c:otherwise>
</c:choose>