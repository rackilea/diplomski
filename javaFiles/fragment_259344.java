<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<c:set var="row3Value" value="${fn:split(model.getMappings()[${index}].userSetting, ',')}" />

<form:select id="${id}" path="Mappings[${index}].userSetting">
    <c:forEach var="item" items="${dropdownValues}">
        <c:choose>
            <c:when test="${row3Value[0] eq ${item.value}}">
                <form:option selected="true" value="${item.value}"><spring:eval expression="item" /></form:option>
            </c:when>

            <c:otherwise>
                <form:option value="${item.value}"><spring:eval expression="item" /></form:option>
            </c:otherwise
        </c:choose> 
    </c:forEach>
</form:select>