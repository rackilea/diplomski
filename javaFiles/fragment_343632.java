<c:forEach var="product" items="${products}">
  <ul>
    <li><c:out value="${product.name}"/></li>
    <li><fmt:formatNumber value="${product.price}" type="CURRENCY"/></li>
    <li>${product.qty}</li>
  </ul>
</c:forEach>