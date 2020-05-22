<c:forEach items="${meetingList}" var="meetingType">
    <td>  This from MeetingTypes:  ${meetingType.typeName}</td> 
    <c:forEach items="${meetingType.Meetings}" var="meet">
        <td>  This from Meetings:   ${meet.roomName}   </td>        
    </c:forEach>
</c:forEach>