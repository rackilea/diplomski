<c:forEach items="${upcomingSchedule}" var="conf">
    <c:set var="title" value="${conf.subject}: "/>
    <c:forEach items="${conf.invitees}" var="invitee">
        <c:set var="title" value="${title} ${invitee}, "/>
    </c:forEach>
    <div class='scheduled' title="${title}" id="scheduled<c:out value="${conf.id}"/>">
    ...
    </div>
</c:forEach>