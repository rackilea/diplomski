<c:forEach var="configParams" items="${configParamsMap}" varStatus="itemsRow">
   <tr>
        <td>
        <c:out value="${configParams.key}" />
        </td>
        <td><input type="text" name="" value="${configParams.value}" /></td>
  </tr>
</c:forEach>