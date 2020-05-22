<select id="names" name="names">
<c:forEach items="${names}" var="names">

    <c:when test="${loggedInUser eq names}">    
        <option value ="<c:out value="${names}"/>" selected="selected">${names}</option>
    </c:when>
    <c:otherwise>
        <option><c:out value="${names}"/></option> 
    </c:otherwise>  
</c:forEach>