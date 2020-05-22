<c:forEach items="${users}" var="user">
      <tr>
          <td>
              <c:out value="${user.userId}"/>
          </td>
          <td>
              <c:out value="${user.login}" />
         </td>
     </tr>
</c:forEach>