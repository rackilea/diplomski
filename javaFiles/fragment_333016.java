<table>
  <c:forEach items="${products}" var="product">
    <tr>
      <td><c:out value="${product.tareWeight}" /></td>
      <td><c:out value="${product.barCode}" /></td>
    </tr>
  </c:forEach>
</table>