<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
...
<table>
    <c:forEach items="${dataList}" var="dataItem">
        <tr>
            <td>${dataItem.someProperty}</td>
            <td>${dataItem.otherProperty}</td>
        </tr>
    </c:forEach>
</table>