<c:forEach items="${otherListOfData}" var="data">
    <c:if test="${data.id == dataToMatchOn.id}">
        <c:set var="selectedItem" value="${data}/>
    </c:if>
</c:forEach>

<p>From here on I can work with the selected item:</p>

${selectedItem.children}