<c:forEach var="Customer" items="${listCustomer}" >
   <%  String selected = "";  
       if (customer.equals(predeterminedCustomerToBeSelected)) {
           selected = "selected"; }
   %>
      <option value="<c:out value="${Customer}" />" <%=selected%>><c:out value="${Customer}" />
      </option>
 </c:forEach>