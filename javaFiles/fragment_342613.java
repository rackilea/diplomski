<c:choose>
 <c:when test="${i.tag = 'th'}"><c:out value="&lt;th&gt%" /></c:when>
 <c:when test="${i.tag = 'td'}"><c:out value="&lt;td&gt%" /></c:when>
</c:choose>
 <!-- 100 lines of code --> 
<c:choose>
 <c:when test="${i.tag = 'th'}"><c:out value="&lt;/th&gt%" /></c:when>
 <c:when test="${i.tag = 'td'}"><c:out value="&lt;/td&gt%" /></c:when>
</c:choose>