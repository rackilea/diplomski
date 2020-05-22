<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
   <body>
      <%-- will iterate the messages collection put in 
           request scope in the servlet --%>
      <c:forEach items="${messages}" var="message">
         Message = ${message.someProperty"}
      </c:forEach>
   </body>
</html>