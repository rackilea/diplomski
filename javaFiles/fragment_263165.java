<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
   List<String> language = new ArrayList();
   language.add("English");
   language.add("French");
   language.add("Spanish");
   pageContext.setAttribute("language", language);
%>
<c:if test="${fn:length(language) > 2}">
     list length is greater than 2
</c:if>    
${language}