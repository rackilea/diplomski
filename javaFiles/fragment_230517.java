<c:forEach var="topic" items="${model.selectedTopics}" varStatus="loop">
    //omitted displaying of topic details
  <c:forEach items="${flowRequestContext.messageContext.allMessages}" var="message">
    <c:set var="msgSrc" value="selectedTopics[${loop.index}].room"></c:set>
    <c:if test="${message.source eq msgSrc}">
        <c:if test="${message.severity eq 'INFO'}">
            <span class="infoText">${message.text}</span>
        </c:if>
     </c:if>
  </c:forEach>
</c:forEach>