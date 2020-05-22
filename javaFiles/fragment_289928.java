<%
 String ref_name= request.getParameter("ref_logtime");
 pageContext.setAttribute("ref_name", ref_name);
 ref.FindClosestToMultiplesOfTen(ref_name);
 ref.refernece(ref_name); //******* 1st call *********
%>
<table width = "300px" border = "1" cellspacing="2">

 <tr><c:forEach var="r" items="${ref.refernece(param.ref_logtime)}">//***2nd call*** 
 <td><c:out value="${r}"></c:out></td>
 </c:forEach></tr>
 </table>