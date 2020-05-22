<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>




<ul>
    <c:forEach var ="menuitems" items="${menuitem}">
        <li><a href="#">${menuitems.name}</a></li>
        <ul>
   <c:if test="${fn:length(menuitems.children) gt 0}">
      <li class="droprightMenu">
          <c:out value="Has children"></c:out>
         <%--<c:forEach var="menuitemc" items="${menuitems.children}">--%>
           <c:set var="menuitem" value="${menuitems.children}" scope="request" />
           <jsp:include page="menuitem.jsp" />
         <%--</c:forEach>--%>
      </li>
   </c:if>
      </ul>
      </c:forEach>
</ul>