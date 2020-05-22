<c:choose>
    <c:when test="${empty sessionScope.languageRB}">
        <html:hidden property="language" value="en"/>
        <html:hidden property="country" value="GB"/>
    </c:when>
    <c:otherwise>
        <html:hidden property="language" value="${languageRB['style.language']}"/>
        <html:hidden property="country" value="${languageRB['style.country']}"/>
    </c:otherwise>
</c:choose>