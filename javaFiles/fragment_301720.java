<%    pageContext.setAttribute("monEnum", ConstanteADMD.ListTypeAffichage.values()); %>

...
<c:forEach var="entry" items="${monEnum}">
    <option>${entry.type}</option>
</c:forEach>