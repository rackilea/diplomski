<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
//...
data.addRows([
    <c:forEach items="${AuditsByTime}" var="row">
        [new Date(${row.key}),${fn:join(row.value,',')}],
    </c:forEach> 
]);