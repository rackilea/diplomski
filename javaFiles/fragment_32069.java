<c:forEach var="field" items="${fieldList}">
    <spring:bind path="myBean.${field.fieldName}">
        <input type="text" class="text" name="${status.expression}" value="${myBean[field.fieldName]}" />
        <span id="${status.expression}Error" class="error">
            <c:forEach items="${status.errorMessages}" var="error">
                <c:out value="${error}" />
            </c:forEach>
        </span>
    </spring:bind>
</c:forEach>