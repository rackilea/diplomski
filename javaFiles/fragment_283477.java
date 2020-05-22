<tr bgcolor="ffffff" th:each="product: ${products}">
  <td height="50" align="center"><h2 th:text="${product.product.name}"></h2></td>
  <td height="50" align="center"><h2 th:text="${product.amount}"></h2></td>
  .
  .
  .
</tr>