<c:forEach items="${ticketMap}" var="ticketEntry">
    MUID: ${ticketEntry.key}<br>
    Ticket count: ${fn:length(ticketEntry.value)}<br>
    All tickets:<br>
    <c:forEach items="${ticketEntry.value}" var="ticket">
        Number: ${ticket.number}<br>
        Name: ${ticket.name}<br>
        Lastname: ${ticket.lastName}<br>
    </c:forEach>
    <hr>
</c:forEach>