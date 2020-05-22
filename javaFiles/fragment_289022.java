<c:choose>
   <c:when test="${yourcondition}">
      <c:set var="flag" value="true" />
   </c:when>
   <c:otherwise>
      <c:set var="flag" value="false" />  
   </c:otherwise>
</c:choose>