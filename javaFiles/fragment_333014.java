<table>
  <c:forEach items="${TAREWEIGHT}" var="tareWeight" varStatus="loop">
    <c:set var="barCode" value="${BARCODE[loop.index]}" />
    <tr>
      <td><c:out value="${tareWeight}" /></td>
      <td><c:out value="${barCode}" /></td>
    </tr>
  </c:forEach>
</table>