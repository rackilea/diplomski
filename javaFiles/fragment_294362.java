<form action="/registration" method="post">
   <%-- error messages --%>
   <div class="form-group">
    <c:forEach items="${registrationErrors}" var="error">
    <p class="error">${error}</p>
     </c:forEach>
   </div>