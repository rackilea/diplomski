<c:catch var="catchString">
  <c:set var="myString" value="${0 + 'asd1234'}" />
</c:catch>
<c:if test="${not empty catchString}">
  <p>Failed: ${catchString}</p>
</c:if>

<c:catch var="catchNumber">
  <c:set var="myNumber" value="${0 + '1234'}" />
</c:catch>
<c:if test="${not empty catchNumber}">
  <p>Failed: ${catchNumber}</p>
</c:if>