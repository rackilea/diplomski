<c:choose>
    <c:forEach items="${months}" var="month">
        <c:when test="${month == 'March'}">
            <option value="${month}" selected>${month}</option>
        </c:when>
        <c:otherwise>
          <option value="${month}">${month}</option>
        </c:otherwise>
    </c:forEach>
  </c:choose>