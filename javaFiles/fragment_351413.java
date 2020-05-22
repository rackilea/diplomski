<c:forEach var="abcTyp" items="${abcTypeList}">
  <c:set var="labelVar">
      <spring:message code="label.admin.lot.${abcType.value}" />
  </c:set>    
  <form:radiobutton path="abcType" label="${labelVar}" value="${abcTyp.value}" onclick="actSingStone();"/>    
</c:forEach>