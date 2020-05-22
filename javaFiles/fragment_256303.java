<c:choose>
  <c:when test="${bean.value == 2}">
    <p>True</p>
  </c:when>
  <c:otherwise>
    <p>False</p>
  </c:otherwise>
</c:choose>