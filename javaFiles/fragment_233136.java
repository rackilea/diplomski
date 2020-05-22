<c:forEach items="${model.availableitems}" var="item">
  <form:form method="post" commandName="myCommand">
    <span class="item">${item.description}</span> 
    <input type="hidden" name="id" value="${item.ID}"/>
    <input type="submit" name="SelectButton" value="Select" />
  </form:form>        
</c:forEach>