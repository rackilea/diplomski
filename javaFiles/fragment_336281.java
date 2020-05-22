<%@ tag body-content="empty" %>
<%@ attribute name="key" required="true" %>
<%@ attribute name="defaultvalue" required="true"  %>

<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"      %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"       %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="msg"><fmt:message key="${key}" /></c:set>

<c:choose>

    <c:when test="${!fn:startsWith(msg,'???')}">
        ${msg}
    </c:when>    

    <c:otherwise>
        ${defaultvalue}
    </c:otherwise>

</c:choose>