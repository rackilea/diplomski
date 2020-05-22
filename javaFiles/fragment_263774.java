<c:forEach items="${list}" var="map">
       <c:forEach items="${map}" var="entry">
              ${entry.key}<br>
              ${entry.value}<br>
       </c:forEach>
 </c:forEach>