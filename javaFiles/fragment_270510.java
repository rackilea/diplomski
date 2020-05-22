<c:forEach var="entry" items="${hm}">
          Key: <c:out value="${entry.key}"/>
          Value: <c:out value="${entry.value}"/>
          <c:set var="hm1" value="${Value}">
          <c:forEach var="entry" items="${hm1}"/>
              Key1: <c:out value="${entry1.key}"/>
              Value1: <c:out value="${entry1.value}"/>  
          </c:forEach>
   </c:forEach>