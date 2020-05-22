<%
...
List myList = ExplorerViewContext.getNetworkControllers();
java.util.Collections.sort(myList,NC_ORDER);
pageContext.setAttribute("myList", myList); //set in pageContext so JSTL can see it
%>
<c:forEach var="nc" items="${myList}">