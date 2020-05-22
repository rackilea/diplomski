<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!doctype>
<html>
    <head>
       <script src="${pageContext.request.contextPath}/js/jquery-1.3.2.min.js" type="text/javascript></script>
       <script src="${pageContext.request.contextPath}/js/jquery.dd.js" type="text/javascript"></script>
       <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/dd.css" />
    </head>
    <body>
        <form:select id="userNames" path="userName" tabindex="10">
            <form:option value="Select User">Select User</form:option>                
            <c:forEach begin="${userlist begin index (0)}" end="${userlist size}" var="i">
                <c:choose>
                    <c:when test="${userNameList.user.accessLevel == 1}">
                        <form:option style="background-image:url(greentick.png);" value="${userNameList.user.userName}">${userNameList.user.userName}</form:option>
                    </c:when>
                    <c:otherwise>
                        <form:option style="background-image:url(redcross.png);" value="${userNameList.user.userName}">${userNameList.user.userName}</form:option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </form:select>
    </body>
</html>