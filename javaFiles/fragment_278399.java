<c:forEach items="${result}" var="item">
                <tr>
                    <td>${item._id}</td>
                    <td>${item.postDesc}</td>
                  <c:forEach items="${result.intrestReceived}" var="intr">
                    <tr><td>${intr._id}</td></tr>
          </c:forEach>
                </tr>
</c:forEach>