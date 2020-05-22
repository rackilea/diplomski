<c:forEach items="${notes}" var="note">
    <c:if test="${empty prevNote or note.userCode != prevNote.userCode}">
         <c:out value="${note.userCode}" />
    </c:if>
    <c:set var="prevNote" value="${note}" />
</c:forEach>