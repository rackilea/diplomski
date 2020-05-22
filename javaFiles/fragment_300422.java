<c:forEach items="${myList}" var="element"> 
  <tr>
    <td>${element.status}</td>
    <td>${element.requestType}</td>
    <td>${element.requestedFor}</td>
    <td>${element.timeSubmitted}</td>
  </tr>
</c:forEach>