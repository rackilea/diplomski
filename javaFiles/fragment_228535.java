<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>my cart</title>
</head>
<body>
<table>
  <tr bgcolor="#EAEAFF">       
    <td><b>Product ID</b></td>   
  </tr>
  <c:forEach items="${Cart}" var="current">
    <tr>
     <td><c:out value="${current}" /></td>            
    </tr>
  </c:forEach>      
 </table>
</body>
</html>