<c:choose>
 <c:when test="${i.tag = 'th'}">
  <th>
   <my:customTag anyAttributes="th-related-values-if-any" ... />
  </th>
 </c:when>
 <c:when test="${i.tag = 'td'}">
  <td>
   <my:customTag anyAttributes="td-related-values-if-any" ... />
  </td>
 </c:when>
</c:choose>