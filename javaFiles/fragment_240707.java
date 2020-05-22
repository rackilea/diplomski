<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty request.records}">

  <table>
    <c:forEach items="${request.records}" var="record">
       <tr><td> ${record} </td></tr>
    </c:forEach>
  </table>

</c:if>