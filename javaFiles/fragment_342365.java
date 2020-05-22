<c:forEach var="data" items="${list1}" varStatus="loop">
 <tr>
 <td> ${sno+1} </td>  
 <c:forEach var="innerData" items="${data}">
 <td> ${innerData} </td>                      
 </c:forEach>
 <c:set var="sno" value="${sno+1}"/>
 </tr>
 </c:forEach>