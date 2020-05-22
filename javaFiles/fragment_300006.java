<c:forEach items='${list}' var="travel">
    <portlet:actionURL name="getTravelId" var="travelIdUrl">
        <portlet:param name="idTravel" value="${travel.id}"/>
    </portlet:actionURL>
    <a href="${travelIdUrl}">${travel.id}</a>
</c:forEach>