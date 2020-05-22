<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
...
<table class="t1">
  <tr>
    <td>
      <c:forEach items="${terms}" var="term">
        <c:if test="${term.sorter == 1}">
          ${term.code}, ${term.description}, ${term.date}
        </c:if>
      </c:forEach>
    </td>
  </tr>
</table>
<table class="t2">
  <tr>
    <td>
      <c:forEach items="${terms}" var="term">
        <c:if test="${term.sorter == 1 and fn:endsWith(term.code, 'SU')}">
          ${term.code}, ${term.description}, ${term.date}
        </c:if>
      </c:forEach>
    </td>
  </tr>
</table>