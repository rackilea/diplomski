<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
...
<table>
  <c:forEach items="${list}" var="item">
    <tr>
      <td><c:out value="${item}" /></td>
    </tr>
  </c:forEach>
</table>