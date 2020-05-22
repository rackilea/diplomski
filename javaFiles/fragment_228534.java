...
<% ArrayList cart=(ArrayList)session.getAttribute("Cart"); 
out.println(cart);
//this line is working
%>
...
<c:forEach items="${cart}" var="current">