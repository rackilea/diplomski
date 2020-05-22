<table>
   <c:forEach begin="0" end="${numRows - 1}" varStatus="i">
      <c:set var="rowStart" value="${i.index * numColumns}" />
      <tr>
          <fmt:formatNumber var="numColumns" value="${fn:length(values) / numRows}"
             maxFractionDigits="0" />
          <c:forEach begin="0" end="${numColumns - 1}" varStatus="j">
             <c:set var="index" value="${rowStart + j.index}"/>
             <td>
                <c:choose>
                   <c:when test="${index lt fn:length(values)}">
                      <%-- Replace following code with the one needed to display your item --%>
                      <c:out value="${values[index]}" />
                   </c:when>
                   <c:otherwise>&nbsp;</c:otherwise>
                </c:choose>
             </td>
         </c:forEach>
      </tr>
   </c:forEach>
</table>