<c:forEach items="${users}" var="user">
       <tr>
           <td>${user.userId}</td>
           <td>${user.login}</td>
       </tr>
 </c:forEach>