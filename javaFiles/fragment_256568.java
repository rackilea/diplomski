<%-- this will go into a general include file: --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${actionBean.context}"/>
<% pageContext.setAttribute("US", java.util.Locale.US); %>

<c:if test="${context.locale.country == US}">
  <jsp:include page="about_us.jsp"/>
</c:if>