<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%
   pageContext.setAttribute( "currentUser", "Андрей");
%>
Test page.
<c:if test = "${currentUser eq 'Андрей'}" >
     Yes, they are equal.
</c:if> 
<c:if test = "${currentUser eq currentUser}" >
     Yes, they are equal. currentUesr is ${currentUser}
</c:if>