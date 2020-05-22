<!-- Note: no parenthesis usage -->
<c:forEach items="#{agencyBean.listAgencies}" var="inputBoxes">
    <!-- no need to call the getter verbosely, Expression Language call it for you automatically -->
    <h:outputText value="#{inputBoxes.user.name}" />
    <!-- what you want to do here? -->
    <h:inputText />
</c:forEach>